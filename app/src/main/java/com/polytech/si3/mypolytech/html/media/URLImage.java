package com.polytech.si3.mypolytech.html.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by david on 19/04/2016.
 */
public class URLImage extends AsyncTask<String, Void, Bitmap> {
    ImageView image;
    private static HashMap<String,Bitmap> cache = new HashMap<>();

    public URLImage(ImageView image) {
        this.image = image;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon = null;
        try {
            if(cache.containsKey(urldisplay))
                mIcon = cache.get(urldisplay);
            else {
                InputStream in = new java.net.URL(urldisplay).openStream();
                Log.v("URLIMAGE: ", urldisplay);
                mIcon = BitmapFactory.decodeStream(in);
                cache.put(urldisplay,mIcon);


            }
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

    public HashMap<String,Bitmap> getCache(){
        return cache;
    }

    public void clearCache(){
        cache.clear();
    }
}
