package fr.unice.polytech.polynews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import news.Article;

/**
 * Created by eric on 30/03/2016.
 */
public class ArticleActivity extends AppCompatActivity {

    private Article article;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.article_view);
        article = getIntent().getExtras().getParcelable("article");

        ImageView image = (ImageView) findViewById(R.id.imageArticle);
        DownloadImage downloadImage = new DownloadImage(image);
        downloadImage.execute(article.getMediaImage());


        TextView content = (TextView) findViewById(R.id.textArticle);
        content.setText(article.getContent());
    }
}
