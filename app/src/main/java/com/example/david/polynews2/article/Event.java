package com.example.david.polynews2.article;

import com.example.david.polynews2.html.media.YoutubeAPI;
import com.example.david.polynews2.map.Location;

/**
 * Created by david on 21/04/2016.
 */
public class Event extends Article{

    private Location location;

    public Event(int id){
        super(id);
    }


    @Override
    public void setCategory(int c){
        super.setCategory(c);
        this.category = Category.POLITICS;
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

}
