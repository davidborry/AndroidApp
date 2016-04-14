package com.example.david.polynews2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.david.polynews2.article.Article;
import com.example.david.polynews2.css.CSSBuilder;
import com.example.david.polynews2.db.NewsDBHelper;
import com.example.david.polynews2.html.parser.HTMLBuilder;

public class TestActivity extends AppCompatActivity {

    private WebView web;
    private Button buttonMenu;

    private View.OnClickListener menuClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(TestActivity.this, MenuActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        NewsDBHelper dbNews = new NewsDBHelper(this);
        buttonMenu = (Button) findViewById(R.id.hello);
        buttonMenu.setOnClickListener(menuClick);


        try{
            Article a =  dbNews.readDataBase().get(0);

            CSSBuilder css = new CSSBuilder(this);
            css.build("article.css");

            HTMLBuilder h = new HTMLBuilder(a,this);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
