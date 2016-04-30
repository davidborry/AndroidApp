package com.example.david.polynews2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.david.polynews2.adapter.NewsAdapter;
import com.example.david.polynews2.article.New;
import com.example.david.polynews2.css.CSSBuilder;
import com.example.david.polynews2.db.NewsDBHelper;
import com.example.david.polynews2.html.parser.ArticleHTMLBuilder;
import com.example.david.polynews2.storage.Copy;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by david on 19/04/2016.
 */
public class NewsActivity extends BackActivity {

    private NewsAdapter newsAdapter;
    private static String currentURL;
    NewsDBHelper dbNews = new NewsDBHelper(this);

    private final String path = "file:///data/data/com.example.david.polynews2/html/news/";
    ArrayList<New> news;

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent newActivity = new Intent(NewsActivity.this, WebActivity.class);
            try{

                New a = (New) parent.getAdapter().getItem(position);
                Bundle bundle = new Bundle();
                bundle.putString("url",path+a.getId()+".html");
                bundle.putString("title",a.getTitle());
                newActivity.putExtras(bundle);

            }

            catch(Exception e){
                Log.e("ARTICLEERROR:", e.toString());
            }
            startActivity(newActivity);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news);
        NewsDBHelper dbNews = new NewsDBHelper(this);

        getSupportActionBar().setTitle("L'Actu");

        try{
            news = (ArrayList) dbNews.readDatabase();
            buildArticles();

            NewsAdapter newsAdapter = new NewsAdapter(this,news);

            ListView listView = (ListView) findViewById(R.id.news_list);


            listView.setOnItemClickListener(itemClickListener);
            listView.setAdapter(newsAdapter);
        }

        catch (Exception e){

            Log.e("Error : ",e.toString());

        }

    }

    public void buildArticles() throws IOException{
        Copy.mkdir("html/news");

        Copy.mkdir("css");
        CSSBuilder css = new CSSBuilder(this);
        css.build("article.css");

        for(int i = 0; i < news.size();i++){
            New article = news.get(i);
            ArticleHTMLBuilder builder = new ArticleHTMLBuilder(article,this);
            builder.save("news/"+article.getId()+".html");
        }
    }

}
