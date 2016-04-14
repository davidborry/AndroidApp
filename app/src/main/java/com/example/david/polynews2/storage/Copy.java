package com.example.david.polynews2.storage;

import android.content.Context;

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
}
