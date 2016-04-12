package com.example.david.polynews2.article;

/**
 * Created by David on 23/03/16.
 */
public class Article {
    private int id;
    private String title;
    private String body;
    private String author;
    private String date;
    private Category category;
    private Media media;

    public enum Category{
        POLITICS,
        SOCIETY;

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

    public Article(int id){
        this.id = id;
    }

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

    public Category getCategory(){
        return category;
    }

    public void setCategory(int c){
        if(c == 1)
            category = Category.POLITICS;
        else
            category = Category.SOCIETY;

        category.setT(c);

    }

    public Media getMedia(){
        return media;
    }

    public void setMedia(int c, String url){
        if(c == 0)
            media = Media.IMAGE;
        else
            media = Media.VIDEO;

        media.setURL(url);
    }

    @Override
    public String toString(){
        return author+": "+title+"\n"+body+"\n"+date;
    }
}