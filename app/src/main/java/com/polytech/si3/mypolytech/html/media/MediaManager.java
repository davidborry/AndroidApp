package com.polytech.si3.mypolytech.html.media;

/**
 * Created by david on 13/04/2016.
 */
public class MediaManager {
    protected int width;
    protected int height;
    protected String URL;

    public MediaManager(int width, int height,String URL){
        this.width = width;
        this.height = height;
        this.URL = URL;
    }
}
