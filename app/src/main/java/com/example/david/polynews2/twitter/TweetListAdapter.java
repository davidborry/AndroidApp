package com.example.david.polynews2.twitter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.david.polynews2.html.media.URLImage;
import com.example.david.polynews2.R;

/**
 * Created by eric on 21/04/2016.
 */
public class TweetListAdapter extends ArrayAdapter<Tweet> {
    private ArrayList<Tweet> tweets;

    public TweetListAdapter(Context context, int resource, ArrayList<Tweet> items) {
        super(context, resource, items);
        this.tweets = items;
        this.getContext();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_tweet, null);
        }

        Tweet tweet = tweets.get(position);

        //Affichage de la date du tweet

        TextView date = (TextView) convertView.findViewById(R.id.date);
        date.setText(tweet.getStandardDate());

        //Affichage contenu du tweet

        TextView content = (TextView) convertView.findViewById(R.id.content);
        content.setText(tweet.content);

        //Affichage image

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageTweet);
        new URLImage(imageView).execute(getItem(position).getImageUrl());


        return convertView;
    }
}
