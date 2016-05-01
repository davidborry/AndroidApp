package com.polytech.si3.mypolytech.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.polytech.si3.mypolytech.R;
import com.polytech.si3.mypolytech.article.New;
import com.polytech.si3.mypolytech.html.media.URLImage;

import java.util.ArrayList;

/**
 * Created by david on 19/04/2016.
 */
public class NewsAdapter extends ArrayAdapter<New> {

    public NewsAdapter(Context context, ArrayList<New> news) {
        super(context,0,news);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        New article = getItem(position);

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
