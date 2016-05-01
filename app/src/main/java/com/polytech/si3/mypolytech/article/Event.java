package com.polytech.si3.mypolytech.article;

import com.polytech.si3.mypolytech.map.Location;

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

        switch(c){
            case 0:
                this.category = Category.POLYTECH;
                break;
            case 1:
                this.category = Category.BDE;
                break;
            case 2:
                this.category = Category.BDS;
                break;
            case 3:
                this.category = Category.BDM;
                break;
            case 4:
                this.category = Category.BDJ;
                break;
            case 5:
                this.category = Category.CONFERENCE;
                break;
            case 6:
                this.category = Category.APERO;
                break;
            default:
                this.category = Category.DIVERS;
        }

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
