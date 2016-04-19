package com.example.david.polynews2;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by david on 19/04/2016.
 */
public class WebActivity extends BackActivity {
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpage);

        Bundle extra = getIntent().getExtras();
        url = extra.getString("url");

        WebView webView = (WebView) findViewById(R.id.web_page);
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

}
