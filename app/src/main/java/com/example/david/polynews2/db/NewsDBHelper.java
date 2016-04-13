package com.example.david.polynews2.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.david.polynews2.article.Article;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDBHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.example.david.polynews2/databases/";
    private static String DB_NAME = "polynews_database";
    private static final String COMMAND = "SELECT * FROM news ORDER BY date DESC";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public NewsDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
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
            String myPath = DB_PATH + DB_NAME;
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
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
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

        String myPath = DB_PATH+DB_NAME;
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
            Log.e("DBERROR:",e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public List<Article> readDataBase() throws SQLException{
        List<Article> articles = new ArrayList<Article>();
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
            Article l = getArticle(id,cursor);
          //  Log.v("ARTICLEURL:",l.getMedia().getURL());
            articles.add(l);
            cursor.moveToNext();
        }

        cursor.close();
        return articles;
    }

    private Article getArticle(int id, Cursor cursor){
        Article l = new Article(id);

        l.setTitle(cursor.getString(0));
        l.setBody(cursor.getString(1));
        l.setAuthor(cursor.getString(2));
        l.setDate(cursor.getString(3));
        l.setCategory(cursor.getInt(4));
        l.setMedia(cursor.getInt(5),cursor.getString(6));

        return l;
    }
}