package com.example.david.polynews2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.david.polynews2.article.Article;
import com.example.david.polynews2.db.NewsDBHelper;
import com.example.david.polynews2.html.parser.HTMLBuilder;

public class MainActivity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsDBHelper dbNews = new NewsDBHelper(this);
        try{
            Article a =  dbNews.readDataBase().get(0);
            HTMLBuilder h = new HTMLBuilder(a);

            h.save("test.html");
            web = (WebView) findViewById(R.id.web);

            WebSettings ws = web.getSettings();
            ws.setJavaScriptEnabled(true);
            web.loadUrl("file:///data/data/com.example.david.polynews2/databases/test.html");

        }

        catch(Exception e){
            Log.e("DBERROR:", e.toString());
        }
    }
}
