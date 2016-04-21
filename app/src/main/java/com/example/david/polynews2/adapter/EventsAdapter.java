package com.example.david.polynews2.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.polynews2.EventsActivity;
import com.example.david.polynews2.MapsActivity;
import com.example.david.polynews2.R;
import com.example.david.polynews2.WebActivity;
import com.example.david.polynews2.article.Event;
import com.example.david.polynews2.html.media.URLImage;
import com.example.david.polynews2.map.Location;

import java.util.ArrayList;

/**
 * Created by david on 21/04/2016.
 */
public class EventsAdapter extends ArrayAdapter<Event> {

    private ImageButton imageButton;

    public EventsAdapter(Context context, ArrayList<Event> events) {
        super(context,0,events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final Event event = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_event, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.event_title);
        TextView author = (TextView) convertView.findViewById(R.id.event_author);
        TextView date = (TextView) convertView.findViewById(R.id.event_date);
        TextView location = (TextView) convertView.findViewById(R.id.event_location);
        ImageView icon = (ImageView) convertView.findViewById(R.id.event_icon);

        title.setText(event.getTitle());
        author.setText(event.getAuthor());
        date.setText(event.getDate());
        location.setText(event.getLocation().getName());

        new URLImage(icon).execute(event.getIconUrl());

        imageButton = (ImageButton) convertView.findViewById(R.id.eventlocate_icon);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(v.getContext(),MapsActivity.class);
                Bundle extras = new Bundle();
                Location l = event.getLocation();
                extras.putString("event",l.getName());
                extras.putFloat("lat",l.getLat());
                extras.putFloat("lng",l.getLng());
                extras.putInt("cat",l.getCategory());
                newActivity.putExtras(extras);

                Log.v("COORD:",l.getLat()+ " - " + l.getLng());

                v.getContext().startActivity(newActivity);
            }
        });

        return convertView;
    }
}
