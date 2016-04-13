package com.example.david.polynews2.html.parser;

import android.util.Log;

import com.example.david.polynews2.article.Article;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Created by david on 12/04/2016.
 * Creates a simple HTML5 web page based on an Article object
 */
public class HTMLBuilder {
    private Article article;
    private String filepath;
    private String URL = "/data/data/com.example.david.polynews2/databases/";
    private String content;

    public HTMLBuilder(Article article){
        this.article = article;
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
        content+="</head>\n";
    }

    public void makeBody(){
        content+="<body>\n";
        content+="<h1 id=\"title\">"+article.getTitle()+"</h1>\n";
        content+="<h2 id=\"author\">" + article.getAuthor() + "</h2>\n";
        content+="<p id=\"date\">" + article.getDate() + "</p>\n";
        content+="<p id=\"category\">"+article.getCategory().toString()+"</p>\n";
        content+="<p id=\"content\">" + article.getBody() + "</p>\n";
        makeMedia();
        //content+="<a id=\"media\" href=\""+article.getMedia().getURL()+"\">MEDIA</a>\n";
        content+="</body>\n";
        Log.v("CONTENTARTICLE:",content);

    }

    public void makeMedia(){
        if(article.getMedia() == Article.Media.IMAGE)
            content+="<img src=\""+article.getMedia().getURL()+"\" />\n";

        else
            makeVideo();
    }

    public void makeVideo(){
        Log.v("CONTENTARTICLE:",article.getMedia().getURL());

        if(article.getMedia().getURL().contains("youtube.com")){
            content+= new YoutubeManager(400,400,article.getMedia().getURL()).getEmbedCode();
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
