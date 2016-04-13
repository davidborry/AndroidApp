package com.example.david.polynews2.window;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by david on 13/04/2016.
 * get current device pixel dimensions
 */
public class Dimensions {
    private int width;
    private int height;

    public Dimensions(Context context){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
