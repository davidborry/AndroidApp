package com.example.david.polynews2.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

import com.example.david.polynews2.R;
import com.example.david.polynews2.html.video.Video;

/**
 * Created by Gunther on 3/16/2016.
 */
public class VideosCustomAdapter extends ArrayAdapter<Video> {
    public VideosCustomAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.videos_layout, null);
        }
        final Video video = getItem(position);

        ((ImageView)convertView.findViewById(R.id.news_thumbnail)).setImageBitmap(null);
        String title = video.getTitle().substring(0, Math.min(50, video.getTitle().length()));
        String content = video.getDescription().substring(0, Math.min(100, video.getDescription().length()))+"...";
        ((TextView)convertView.findViewById(R.id.news_title)).setText(title);
        ((TextView)convertView.findViewById(R.id.news_content)).setText(content);

        VideosCustomAdapter.getTask(convertView).execute(video.getThumbnail());
        return convertView;
    }

    public static AsyncTask<String, Void, Bitmap> getTask(final View convertView) {
        return new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... params) {
                try {
                    InputStream is = (InputStream) new URL(params[0]).getContent();
                    return BitmapFactory.decodeStream(is);
                } catch (Exception e) {
                    Log.e("Error", "Cannot read image from url : " + params[0], e);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if(bitmap != null) {
                    ((ImageView)convertView.findViewById(R.id.news_thumbnail)).setImageBitmap(bitmap);
                }
            }
        };
    }
}
