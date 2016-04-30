package com.example.david.polynews2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.david.polynews2.adapter.EventsAdapter;
import com.example.david.polynews2.article.Event;
import com.example.david.polynews2.css.CSSBuilder;
import com.example.david.polynews2.db.EventsDBHelper;
import com.example.david.polynews2.html.parser.ArticleHTMLBuilder;
import com.example.david.polynews2.map.Location;
import com.example.david.polynews2.storage.Copy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 21/04/2016.
 */
public class EventsActivity extends BackActivity {

    ArrayList<Event> events;
    EventsAdapter eventsAdapter;
    ListView listView;
    private final String path = "file:///data/data/com.example.david.polynews2/html/events/";


    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent newActivity = new Intent(EventsActivity.this, WebActivity.class);
            try{

                Event a = (Event) parent.getAdapter().getItem(position);
                Bundle bundle = new Bundle();
                bundle.putString("url",path+a.getId()+".html");
                bundle.putString("title",a.getTitle());

                Location l = a.getLocation();
                bundle.putString("event",l.getName());
                bundle.putFloat("lat",l.getLat());
                bundle.putFloat("lng", l.getLng());
                bundle.putInt("cat", l.getCategory());
                bundle.putInt("id",l.getId());

                newActivity.putExtras(bundle);

            }

            catch(Exception e){
                Log.e("ARTICLEERROR:", e.toString());
            }
            startActivity(newActivity);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getSupportActionBar().setTitle("ÉVÈNEMENTS À VENIR");
        loadDB();

        try{
            buildArticles();
        }

        catch(Exception e){
            Log.e("HTMLERROR: ", e.toString());
        }


    }

    public void loadDB(){
        try{
            events = (ArrayList) (new EventsDBHelper(this).readDatabase());

            eventsAdapter = new EventsAdapter(this,events);

            listView = (ListView) findViewById(R.id.events_list);

            listView.setAdapter(eventsAdapter);
            listView.setOnItemClickListener(itemClickListener);
        }

        catch(Exception e){
            Log.e("DBERROR : ", e.toString());
        }
    }

    public void buildArticles() throws IOException {
        Copy.mkdir("html/events");

        Copy.mkdir("css");
        CSSBuilder css = new CSSBuilder(this);
        css.build("article.css");

        for(int i = 0; i < events.size();i++){
            Event article = events.get(i);
            ArticleHTMLBuilder builder = new ArticleHTMLBuilder(article,this);
            builder.save("events/"+article.getId()+".html");
        }
    }
}
