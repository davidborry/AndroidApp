package com.example.david.polynews2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.david.polynews2.adapter.EventsAdapter;
import com.example.david.polynews2.article.Event;
import com.example.david.polynews2.db.EventsDBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 21/04/2016.
 */
public class EventsActivity extends BackActivity {

    ArrayList<Event> db;
    EventsAdapter eventsAdapter;
    ListView listView;

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent newActivity = new Intent(EventsActivity.this, WebActivity.class);
            Event a = (Event) parent.getAdapter().getItem(position);

            Bundle bundle = new Bundle();

            bundle.putString("url",a.getIconURL());
            bundle.putString("title",a.getTitle());

            newActivity.putExtras(bundle);

            startActivity(newActivity);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getSupportActionBar().setTitle("ÉVÈNEMENTS À VENIR");

        loadDB();


    }

    public void loadDB(){
        try{
            db = (ArrayList) (new EventsDBHelper(this).readDatabase());

            eventsAdapter = new EventsAdapter(this,db);

            listView = (ListView) findViewById(R.id.events_list);

            listView.setAdapter(eventsAdapter);
            listView.setOnItemClickListener(itemClickListener);
        }

        catch(Exception e){
            Log.e("DBERROR : ", e.toString());
        }
    }
}
