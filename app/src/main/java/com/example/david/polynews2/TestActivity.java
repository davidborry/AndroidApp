package com.example.david.polynews2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.david.polynews2.article.New;
import com.example.david.polynews2.css.CSSBuilder;
import com.example.david.polynews2.db.NewsDBHelper;
import com.example.david.polynews2.fragment.MenuFragment;
import com.example.david.polynews2.html.parser.ArticleHTMLBuilder;

public class TestActivity extends BackActivity {

    private WebView web;
    private Button buttonMenu;

    private View.OnClickListener menuClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(TestActivity.this, MenuFragment.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);




        NewsDBHelper dbNews = new NewsDBHelper(this);
        buttonMenu = (Button) findViewById(R.id.hello);
        buttonMenu.setOnClickListener(menuClick);


        try{
            New a =  dbNews.readDatabase().get(0);

            CSSBuilder css = new CSSBuilder(this);
            css.build("article.css");

            ArticleHTMLBuilder h = new ArticleHTMLBuilder(a,this);

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
