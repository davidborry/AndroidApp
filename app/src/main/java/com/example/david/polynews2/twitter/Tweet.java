package com.example.david.polynews2.twitter;

import java.util.Date;

/**
 * Created by eric on 15/04/2016.
 */
public class Tweet {

    String author;
    String content;
    Date date;
    String imageUrl;


    public String getAuthor() {
        return author;
    }
    public String getDate() {
        return date.toString();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getContent() {
        return content;
    }
}
