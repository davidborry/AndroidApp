package com.example.david.polynews2.html.parser;

import android.content.Context;

import com.example.david.polynews2.window.Dimensions;

/**
 * Created by david on 22/04/2016.
 */
public abstract class HTMLBuilder<T> {
    protected String filepath;
    protected String URL = "/data/data/com.example.david.polynews2/databases/";
    protected String content;
    protected Context context;
    protected Dimensions d;

    public HTMLBuilder(Context context){

        this.context = context;
        d = new Dimensions(this.context);
    }


}
