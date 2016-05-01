package com.polytech.si3.mypolytech.db;

import android.content.Context;
import android.database.Cursor;

import com.polytech.si3.mypolytech.article.New;

public class NewsDBHelper extends AbstractDBHelper<New> {

    public NewsDBHelper(Context context) {
        super(context, "polynews_database");
    }

    @Override
    protected New getElement(int id, Cursor cursor) {
        New l = new New(id);

        l.setTitle(cursor.getString(0));
        l.setBody(cursor.getString(1));
        l.setAuthor(cursor.getString(2));
        l.setDate(cursor.getString(3));
        l.setCategory(cursor.getInt(4));
        l.setMedia(cursor.getInt(5), cursor.getString(6));

        return l;
    }
}