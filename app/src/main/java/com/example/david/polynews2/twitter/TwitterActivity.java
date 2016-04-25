package fr.unice.polytech.polynews.twitter;

import android.app.ListActivity;
import android.os.Bundle;


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


}
