package com.polytech.si3.mypolytech.db;

import android.content.Context;
import android.database.Cursor;

import com.polytech.si3.mypolytech.map.Location;

/**
 * Created by david on 20/04/2016.
 */
public class LocationsDBHelper extends AbstractDBHelper<Location> {

    public LocationsDBHelper(Context context){
        super(context,"locations_database");
        changeSelectCommand("SELECT * FROM locations");
    }

    @Override
    public Location getElement(int id, Cursor cursor){
        Location location = new Location(id);

        location.setName(cursor.getString(1));
        location.setLocation(cursor.getString(2));
        location.setCategory(cursor.getInt(3));
        location.setLat(cursor.getFloat(4));
        location.setLng(cursor.getFloat(5));

        return location;
    }
}
