package com.example.david.polynews2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.polynews2.R;
import com.example.david.polynews2.article.Event;
import com.example.david.polynews2.html.media.URLImage;

import java.util.ArrayList;

/**
 * Created by david on 21/04/2016.
 */
public class EventsAdapter extends ArrayAdapter<Event> {

    public EventsAdapter(Context context, ArrayList<Event> events) {
        super(context,0,events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Event event = getItem(position);

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

        return convertView;
    }
}
