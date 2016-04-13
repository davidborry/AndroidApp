package com.example.david.polynews2.css;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by david on 13/04/2016.
 */
public class CSSBuilder {
    private String URL = "/data/data/com.example.david.polynews2/databases/";
    private String content;
    private String fileName = "article.css";
    private Context context;

    public CSSBuilder(Context context){
        this.context = context;
    }
    public void build(String fileName) throws IOException{
        this.fileName = fileName;
        InputStream myInput = context.getAssets().open(fileName);

        FileOutputStream myOutput = new FileOutputStream(URL+fileName);
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
