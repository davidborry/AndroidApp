package com.polytech.si3.mypolytech;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by david on 19/04/2016.
 */
public class WebActivity extends BackActivity {
    private String url;
    private String title;
    private Bundle extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpage);

        extra = getIntent().getExtras();
        url = extra.getString("url");
        title = extra.getString("title");
        checkEvent();

        getSupportActionBar().setTitle(title);

        WebView webView = (WebView) findViewById(R.id.web_page);
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    public void checkEvent(){
        try{
            final String eventName = extra.getString("event");
            final float lat = extra.getFloat("lat");
            final float lng = extra.getFloat("lng");
            final int cat = extra.getInt("cat");


            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.go_to_event);
            linearLayout.setVisibility(View.VISIBLE);

            ImageButton imageButton = (ImageButton) findViewById(R.id.event_on_maps);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent newActivity = new Intent(WebActivity.this,MapsActivity.class);
                    Bundle extras = new Bundle();

                    extras.putString("event",eventName);
                    extras.putFloat("lat",lat);
                    extras.putFloat("lng",lng);
                    extras.putInt("cat",cat);
                    newActivity.putExtras(extras);

                    startActivity(newActivity);
                }
            });
            Log.v("WEBLOCATION: ",extra.getString("event"));
        }

        catch(Exception e){
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.go_to_event);
            linearLayout.setVisibility(View.INVISIBLE);
        }

        }
    }


