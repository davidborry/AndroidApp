package com.example.david.polynews2.html.parser;

import android.util.Log;

import com.example.david.polynews2.article.Article;

/**
 * Created by david on 13/04/2016.
 */
public class YoutubeManager extends MediaManager {

    private String embedURL;

    public YoutubeManager(int width, int height, String URL){
        super(width, height,URL);
        embedURL = URL.replace("watch?v=","embed/");
    }

    public String getEmbedURL(){
        return embedURL;
    }

    public void setEmbedURL(String URL){
        embedURL = URL;
    }

    public String getEmbedCode(){
        Log.v("EMBEDVIDEO:", "<iframe src=\"" + embedURL + "\" width=\"" + width + "\" height=\"" + height + "\"></iframe>");
        return "<iframe id=\"video\" src=\""+ embedURL+"\" width=\"auto\" height=\"auto\" allowFullScreen></iframe>";
    }

}
