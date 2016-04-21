package com.example.david.polynews2.article;

import com.example.david.polynews2.html.media.YoutubeAPI;
import com.example.david.polynews2.map.Location;

/**
 * Created by david on 21/04/2016.
 */
public class Event {
    private int id;
    private String title;
    private String content;
    private String author;
    private String date;
    private int category;
    private int media;
    private String url;
    private String iconUrl;
    private Location location;

    public Event(int id){
        this.id=id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
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

    public int getCategory(){
        return category;
    }

    public void setCategory(int category){
        this.category = category;
    }

    public int getMedia(){
        return media;
    }

    public void setMedia(int media){
        this.media = media;

        if(media == 0)
            iconUrl = url;

        else
            iconUrl = "http://img.youtube.com/vi/" + YoutubeAPI.getVideoId(url) + "/0.jpg";

    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public void setLocation(int id,String name, float lat, float lng){
        location = new Location(id);
        location.setName(name);
        location.setLat(lat);
        location.setLng(lng);
    }

    public String getIconUrl(){
        return iconUrl;
    }

    public void setIconUrl(String iconUrl){
        this.iconUrl = iconUrl;
    }
}
