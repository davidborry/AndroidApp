package com.polytech.si3.mypolytech.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 20/04/2016.
 */
public abstract class AbstractDBHelper<T> extends SQLiteOpenHelper {

    protected static String DB_PATH = "/data/data/com.example.david.polynews2/databases/";
    protected final String db;
    protected String COMMAND = "SELECT * FROM news ORDER BY date DESC";

    protected SQLiteDatabase myDataBase;
    protected final Context myContext;

    public AbstractDBHelper(Context context, String dbName){
        super(context,dbName,null,1);
        this.myContext = context;
        db = dbName;
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if(!dbExist){
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try{
            String myPath = DB_PATH + db;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch(SQLiteException e){
            //database doesn't exist yet.
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null;
    }

    private void copyDataBase() throws IOException{
        InputStream myInput = myContext.getAssets().open(db);
        String outFileName = DB_PATH + db;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLException {
        //Open the database

        String myPath = DB_PATH+ db;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close() {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            copyDataBase();
        }

        catch(Exception e){
            Log.e("DBERROR:", e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void changeSelectCommand(String select){
        COMMAND = select;
    }

    public List<T> readDatabase() throws SQLException {
        List<T> locations = new ArrayList<>();
        try {
            createDataBase();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        openDataBase();
        Cursor cursor = myDataBase.rawQuery(COMMAND, null);

        cursor.moveToFirst();
        int id = 1;
        while(!cursor.isAfterLast()){
            T l = getElement(id, cursor);
            //  Log.v("ARTICLEURL:",l.getMedia().getURL());
            locations.add(l);
            id++;
            cursor.moveToNext();

        }

        cursor.close();
        return locations;
    }

    protected abstract T getElement(int id, Cursor cursor);
}
