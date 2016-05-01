package com.polytech.si3.mypolytech.css;

import android.content.Context;

import com.polytech.si3.mypolytech.storage.Copy;

import java.io.IOException;

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
        Copy.mkdir("css");
        Copy.store(context,fileName, "css/" + fileName);
        /*InputStream myInput = context.getAssets().open(fileName);

        FileOutputStream myOutput = new FileOutputStream(URL+fileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();*/
    }
}
