package com.example.david.polynews2.twitter;

import android.app.ListActivity;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;

import fr.unice.polytech.polynews.R;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by eric on 21/04/2016.
 */
public class DownloadTweet extends AsyncTask<Void, Void, Void> {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private ListActivity activity;
    private Context context;

    public DownloadTweet(ListActivity activity ,Context context){
        this.activity = activity;
        this.context = context;
    }
    @Override
    protected Void doInBackground(Void... params) {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("G0KiKhAUV5H3voys4f9nRVVsT")
                .setOAuthConsumerSecret("vaBs8UQZYBDFAgcqRwdPkqudw1CbH7waicedKiUqMXQtTYNgDm")
                .setOAuthAccessToken("721027420237733888-EZiTsgSBNrrsJdri18SVQvAdva1P7hR")
                .setOAuthAccessTokenSecret("sFnaz6LL8lVjYjx9JmsU5nYAXbBTjs6E7guNuHSzuzn8A");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        long max = -1;

        for (int i = 0; i < 2; i++) {
            Query query = new Query("polytechnice");
            query.setCount(i * 10);
            query.setLang("fr");
            if (max != -1)
                query.setMaxId(max - 1);
            QueryResult result = null;
            try {
                result = twitter.search(query);
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            for (twitter4j.Status status : result.getTweets()) {

                Tweet tweet = new Tweet();
                tweet.date = status.getCreatedAt();
                tweet.content = status.getText();
                tweet.imageUrl = status.getUser().getProfileImageURL();
                //System.out.println(status.getUser());
                tweets.add(tweet);
                if (max < status.getId())
                    max = status.getId();

            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        activity.setListAdapter(new TweetListAdapter(context, R.layout.list_tweet, tweets));

    }
}
