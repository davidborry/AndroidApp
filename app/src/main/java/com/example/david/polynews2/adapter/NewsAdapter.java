package com.example.david.polynews2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.polynews2.R;
import com.example.david.polynews2.article.Article;
import com.example.david.polynews2.html.media.URLImage;

import java.util.ArrayList;

/**
 * Created by david on 19/04/2016.
 */
public class NewsAdapter extends ArrayAdapter<Article> {

    public NewsAdapter(Context context, ArrayList<Article> news) {
        super(context,0,news);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Article article = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_new, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.article_title);
        TextView author = (TextView) convertView.findViewById(R.id.article_author);
        TextView date = (TextView) convertView.findViewById(R.id.article_date);
        ImageView icon = (ImageView) convertView.findViewById(R.id.article_icon);

        title.setText(article.getTitle());
        author.setText(article.getAuthor());
        date.setText(article.getDate());

        //icon.setImageResource(R.drawable.app_test);

        new URLImage(icon).execute(article.getIconURL());

        return convertView;
    }
}
