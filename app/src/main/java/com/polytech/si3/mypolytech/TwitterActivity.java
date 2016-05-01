package com.polytech.si3.mypolytech;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

import com.polytech.si3.mypolytech.twitter.DownloadTweet;


/**
 * Created by eric on 20/04/2016.
 */
public class TwitterActivity extends ListActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DownloadTweet downloadTweet = new DownloadTweet(this, getApplicationContext());
        downloadTweet.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return (super.onCreateOptionsMenu(menu));
    }

}
