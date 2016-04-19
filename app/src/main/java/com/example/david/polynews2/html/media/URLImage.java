package com.example.david.polynews2.html.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by david on 19/04/2016.
 */
public class URLImage extends AsyncTask<String, Void, Bitmap> {
    ImageView image;

    public URLImage(ImageView image) {
        this.image = image;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        image.setImageBitmap(result);
    }
}
