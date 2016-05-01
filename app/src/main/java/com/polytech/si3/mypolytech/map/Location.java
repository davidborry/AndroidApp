package com.polytech.si3.mypolytech.map;

/**
 * Created by david on 20/04/2016.
 */
public class Location {

    private int id;
    private String name;
    private int category;
    private String location;
    private float lat, lng;

    public Location(int id){
        this.id=id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCategory(int category){
        this.category = category;
    }

    public int getCategory(){
        return category;
    }

    public void setLat(float lat){
        this.lat = lat;
    }

    public float getLat(){
        return lat;
    }

    public void setLng(float lng){
        this.lng = lng;
    }

    public float getLng(){
        return lng;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }
}
