package com.example.david.polynews2.article;

import com.example.david.polynews2.html.media.YoutubeAPI;

/**
 * Created by David on 23/03/16.
 */
public class New extends Article{

    public New(int id){
        super(id);
    }

    @Override
    public void setCategory(int c){
        super.setCategory(c);

        if(c == 1)
            category = Category.POLITICS;
        else
            category = Category.SOCIETY;


    }

}