package com.polytech.si3.mypolytech.twitter;

import java.text.SimpleDateFormat;
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
    
    public String getStandardDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy' à 'hh:mm");
        return(simpleDateFormat.format(date));
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getContent() {
        return content;
    }
}
