package com.polytech.si3.mypolytech.html.parser;

import android.content.Context;
import android.util.Log;

import com.polytech.si3.mypolytech.article.Article;
import com.polytech.si3.mypolytech.article.Event;
import com.polytech.si3.mypolytech.html.media.YoutubeManager;
import com.polytech.si3.mypolytech.window.Dimensions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by david on 12/04/2016.
 * Creates a simple HTML5 web page based on an New object
 */
public class ArticleHTMLBuilder {
    private Article article;
    private String filepath;
    private String URL = "/data/data/com.example.david.polynews2/html/";
    private String content;
    private Context context;
    private Dimensions d;

    public ArticleHTMLBuilder(Article article, Context context){
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

        content+="<h1 id=\"title\">" + article.getTitle()+"</h1>\n";
        content+="<h2 id=\"category\">"+article.getCategory().toString()+"</h2>\n";
        content+="<h2 id=\"author\">Publié par: " + article.getAuthor() + "</h2>\n";
        content+="<p id=\"date\">Le " + article.getDate() + "</p>\n";


        makeMedia();

        //content+="<a id=\"media\" href=\""+article.getMedia().getURL()+"\">MEDIA</a>\n";

        content+="<p id=\"content\">" + article.getBody() + "</p>\n";
        content+="</body>\n";
        Log.v("CONTENTARTICLE:",content);

    }

    public void makeMedia(){
        if(article.getMedia() == Event.Media.IMAGE){
            content+="<img width=\"100%\" src=\""+article.getMediaURL()+"\" />\n";
            Log.v("MEDIAURL:",article.getMediaURL());
        }

        else{
            makeVideo();
        }

    }

    public void makeVideo(){
        Log.v("CONTENTARTICLE:",article.getMedia().getURL());

        if(article.getMedia().getURL().contains("youtube.com")){

            content+= "<div class=\"videoWrapper\">\n";
            content+= new YoutubeManager(d.getWidth(),d.getHeight(),article.getMediaURL()).getEmbedCode()+"\n";
            content+="</div>\n";
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
