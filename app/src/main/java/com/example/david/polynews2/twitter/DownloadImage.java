package com.example.david.polynews2.twitter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by eric on 30/03/2016.
 */
public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;


    public DownloadImage(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            InputStream content = new URL(params[0]).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(content);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }


}
