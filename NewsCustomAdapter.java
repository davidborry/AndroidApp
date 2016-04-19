package fr.unice.polytech.polynews;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import news.Article;

/**
 * Created by eric on 23/03/2016.
 */
public class NewsCustomAdapter extends ArrayAdapter<Article> {


    public NewsCustomAdapter(Context context, int resource, List<Article> objects) {
        super(context, resource, objects);
    }



    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_element, null);
        }

        //Afficher les images des articles

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        DownloadImage downloadImage = new DownloadImage(imageView);
        downloadImage.execute(getItem(position).getMediaImage());



        //Affiche le contenu
        TextView date = (TextView) convertView.findViewById(R.id.content);
        date.setText(getItem(position).getContent());

        //Affiche le contenu

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(getItem(position).getTitle());

        return convertView;


    }








}
