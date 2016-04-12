package com.example.david.polynews2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.david.polynews2.db.NewsDBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsDBHelper dbNews = new NewsDBHelper(this);
        try{
            dbNews.readDataBase();

        }

        catch(Exception e){
            Log.e("DBERROR:", e.toString());
        }
    }
}
