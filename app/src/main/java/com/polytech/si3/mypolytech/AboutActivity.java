package com.polytech.si3.mypolytech;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.polytech.si3.mypolytech.css.CSSBuilder;
import com.polytech.si3.mypolytech.storage.Copy;

/**
 * Created by david on 01/05/2016.
 */
public class AboutActivity extends BackActivity {
    private String url = "file:///data/data/com.example.david.polynews2/html/about/about.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpage);
        getSupportActionBar().setTitle("A propos");

        loadPage();

        WebView webView = (WebView) findViewById(R.id.web_page);
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    public void loadPage(){
        try{
            Copy.mkdir("css");
            CSSBuilder css = new CSSBuilder(this);
            css.build("article.css");

            Copy.mkdir("html/about");
            Copy.store(this, "html/about/about.html", "html/about/about.html");
        }
        catch(Exception e){
            Log.e("ABOUTERROR: ", e.toString());
        }
    }
}
