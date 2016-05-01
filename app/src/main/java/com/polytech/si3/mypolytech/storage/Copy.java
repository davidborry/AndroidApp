package com.polytech.si3.mypolytech.storage;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by david on 14/04/2016.
 * copy a file from PC to android device
 */
public class Copy {
    private static String URL = "/data/data/com.example.david.polynews2/";

    /**
     *
     * @param context
     * @param localFileName : PC Path (must exist)
     * @param deviceFileName : Smartphone Path
     * @throws IOException
     */
    public static void store(Context context, String localFileName,String deviceFileName) throws IOException{
        InputStream myInput = context.getAssets().open(localFileName);

        FileOutputStream myOutput = new FileOutputStream(URL+deviceFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public static void store(Context context, String localFileName) throws IOException{
        store(context, localFileName, localFileName);
    }

    public static String getFolders(String path){
        return path.split("/")[path.split("/").length-1];
    }
    public static void mkdir(String path){
        File dir = new File(URL+path);
        try{
            if(!dir.exists()){
                Log.v("DIRPATH: ", dir.getAbsolutePath() + " doesn't exists yet.");
                dir.mkdirs();
            }
        }

        catch(Exception e){
            Log.v("DIRPATHERROR: ",e.toString());
        }
    }
}
