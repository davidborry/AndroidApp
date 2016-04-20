package com.example.david.polynews2.db;

import android.content.Context;
import android.database.Cursor;

import com.example.david.polynews2.map.Location;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 20/04/2016.
 */
public class LocationsDBHelper extends NewsDBHelper {

    public LocationsDBHelper(Context context){
        super(context,"locations_database");
        changeSelectCommand("SELECT * FROM locations");
    }


    public List<Location> readDatabase() throws SQLException {
        List<Location> locations = new ArrayList<Location>();
        try {
            createDataBase();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        openDataBase();
        Cursor cursor = myDataBase.rawQuery(COMMAND, null);

        cursor.moveToFirst();
        int id = 1;
        while(!cursor.isAfterLast()){
            Location l = getLocation(id,cursor);
            //  Log.v("ARTICLEURL:",l.getMedia().getURL());
            locations.add(l);
            id++;
            cursor.moveToNext();

        }

        cursor.close();
        return locations;
    }

    public Location getLocation(int id, Cursor cursor){
        Location location = new Location(id);

        location.setName(cursor.getString(1));
        location.setLocation(cursor.getString(2));
        location.setCategory(cursor.getInt(3));
        location.setLat(cursor.getFloat(4));
        location.setLng(cursor.getFloat(5));

        return location;
    }
}
