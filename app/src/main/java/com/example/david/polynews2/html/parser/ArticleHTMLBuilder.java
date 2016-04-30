package com.example.david.polynews2.html.parser;

import android.content.Context;
import android.util.Log;

import com.example.david.polynews2.article.New;
import com.example.david.polynews2.html.media.YoutubeManager;
import com.example.david.polynews2.window.Dimensions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by david on 12/04/2016.
 * Creates a simple HTML5 web page based on an New object
 */
public class ArticleHTMLBuilder {
    private New article;
    private String filepath;
    private String URL = "/data/data/com.example.david.polynews2/html/";
    private String content;
    private Context context;
    private Dimensions d;

    public ArticleHTMLBuilder(New article, Context context){
        this.article = article;
        this.context = context;
        d = new Dimensions(this.context);
        makePage();
    }

    public void makePage(){
        content = "<!DOCTYPE html>";
        content+="<html>\n";

        makeHead();
        makeBody();

        content+="</html>";
    }

    public void makeHead(){
        content+="<head>\n";
        content+="<meta charset=\"utf-8\" />\n";
        content+="<title>"+article.getTitle() +"</title>\n";
        content+="<link rel=\"stylesheet\" href=\"../../css/article.css\" />\n";
        content+="</head>\n";
    }

    public void makeBody(){
        content+="<body>\n";
        content+="<h1 id=\"title\">"+article.getTitle()+"</h1>\n";
        content+="<h2 id=\"author\">" + article.getAuthor() + "</h2>\n";
        content+="<p id=\"date\">" + article.getDate() + "</p>\n";

        content+="<div class=\"videoWrapper\">\n";
        makeMedia();
        content+="</div>\n";
        //content+="<a id=\"media\" href=\""+article.getMedia().getURL()+"\">MEDIA</a>\n";

        content +="<p id=\"category\">"+article.getCategory().toString()+"</p>\n";
        content+="<p id=\"content\">" + article.getBody() + "</p>\n";
        content+="</body>\n";
        Log.v("CONTENTARTICLE:",content);

    }

    public void makeMedia(){
        if(article.getMedia() == New.Media.IMAGE){
            content+="<img width=\"100%\" src=\""+article.getMediaURL()+"\" />\n";
            Log.v("MEDIAURL:",article.getMediaURL());
        }

        else
            makeVideo();
    }

    public void makeVideo(){
        Log.v("CONTENTARTICLE:",article.getMedia().getURL());

        if(article.getMedia().getURL().contains("youtube.com")){

            content+= new YoutubeManager(d.getWidth(),d.getHeight(),article.getMediaURL()).getEmbedCode();
        }
    }

    public void save(String filePath)throws IOException{

       // Log.v("HTMLPAGE", content);
        this.filepath = filePath;

        FileOutputStream oFile = new FileOutputStream(URL+filePath);
        oFile.write(content.getBytes(Charset.forName("UTF-8")));

        oFile.flush();
        oFile.close();
    }
}
