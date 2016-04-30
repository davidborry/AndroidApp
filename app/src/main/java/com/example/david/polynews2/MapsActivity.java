package com.example.david.polynews2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.david.polynews2.db.LocationsDBHelper;
import com.example.david.polynews2.map.Location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends BackActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Bundle extras;
    private float zoomLevel = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        extras = getIntent().getExtras();

        getSupportActionBar().setTitle("Maps");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


      //  mMap.setMyLocationEnabled(true);
        // Add a marker in Sydney and move the camera

        if(!checkEventExtra())
            loadLocations();

    }

    public boolean checkEventExtra(){

        try{
            String event = extras.getString("event");
            float lat = extras.getFloat("lat");
            float lng = extras.getFloat("lng");
            int cat = extras.getInt("cat");

            LatLng xy = new LatLng(lat,lng);
            MarkerOptions marker = new MarkerOptions().position(xy).title(event);

            mMap.addMarker(marker);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(xy,zoomLevel));

            return true;
        }

        catch (Exception e){
            return false;

        }

    }

    public void loadLocations(){
        LocationsDBHelper db = new LocationsDBHelper(this);

        try{
            ArrayList<Location> locations = (ArrayList) db.readDatabase();

            for(int i = 0; i < locations.size(); i++){
                LatLng xyI = new LatLng(locations.get(i).getLat(),locations.get(i).getLng());
                MarkerOptions markerI = new MarkerOptions().position(xyI).title(locations.get(i).getName());

                if(i==0){
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(xyI, zoomLevel));

                }

                mMap.addMarker(markerI);
            }


        }

        catch(Exception e){
            Log.e("LOCATIONERROR: ",e.toString());
        }

    }
}
