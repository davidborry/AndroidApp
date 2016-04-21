package com.example.david.polynews2.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.david.polynews2.article.Article;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDBHelper extends AbstractDBHelper<Article> {

    public NewsDBHelper(Context context) {
        super(context, "polynews_database");
    }

    @Override
    protected Article getElement(int id, Cursor cursor) {
        Article l = new Article(id);

        l.setTitle(cursor.getString(0));
        l.setBody(cursor.getString(1));
        l.setAuthor(cursor.getString(2));
        l.setDate(cursor.getString(3));
        l.setCategory(cursor.getInt(4));
        l.setMedia(cursor.getInt(5), cursor.getString(6));

        return l;
    }
}