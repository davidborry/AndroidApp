package com.polytech.si3.mypolytech.article;

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