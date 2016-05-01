package com.polytech.si3.mypolytech.article;

import com.polytech.si3.mypolytech.html.media.YoutubeAPI;

/**
 * Created by david on 22/04/2016.
 */
public abstract class Article{

    protected int id;
    protected String title;
    protected String body;
    protected String author;
    protected String date;
    protected String mediaURL;
    protected String iconURL;
    private static final String iconVideo = "https://upload.wikimedia.org/wikipedia/commons/d/d1/Youtube-variation.png";


    protected Category category;
    protected Media media;

    public enum Category{
        POLITICS,
        SOCIETY,
        POLYTECH,
        BDE,
        BDS,
        BDM,
        BDJ,
        CONFERENCE,
        APERO,
        DIVERS
        ;

        private int t;

        public int getT(){
            return t;
        }

        public void setT(int t){
            this.t = t;

        }
    };

    public enum Media{
        IMAGE,
        VIDEO;
        private String URL;

        public void setURL(String URL){
            this.URL = URL;
        }

        public String getURL(){
            return URL;
        }
    };

    public Article(int id){this.id = id;}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getMediaURL(){
        return mediaURL;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(int c){
        category = Category.DIVERS;
        category.setT(c);
    }

    public String getIconURL(){
        return iconURL;
    }

    public Media getMedia(){
        return media;
    }

    public void setMedia(int c, String url){
        if(c == 0){
            media = Media.IMAGE;
            iconURL = url;
        }
        else{
            media = Media.VIDEO;
            //iconURL = iconVideo;
            iconURL = "http://img.youtube.com/vi/" + YoutubeAPI.getVideoId(url) + "/0.jpg";

        }

        media.setURL(url);
        mediaURL = url;
    }


    @Override
    public String toString(){
        return author+": "+title+"\n"+body+"\n"+date;
    }



}
