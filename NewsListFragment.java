package fr.unice.polytech.polynews;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;

import java.io.IOException;
import java.sql.SQLException;

import news.Article;

/**
 * Created by eric on 16/03/2016.
 */
public class NewsListFragment extends Fragment {

    private NewsCustomAdapter customAdapter;



    public static NewsListFragment newInstance(int sectionNumber) {
        NewsListFragment fragment = new NewsListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_list, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final NewsDBHelper dbHelper = new NewsDBHelper(getActivity());

        try {
            dbHelper.createDataBase();
            dbHelper.openDataBase();

            customAdapter = new NewsCustomAdapter(getActivity(), 0, dbHelper.readDateBase());
            GridView gridView = (GridView) getView().findViewById(R.id.gridView);
            gridView.setAdapter(customAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getContext(), ArticleActivity.class);
                    intent.putExtra("article", dbHelper.readDateBase().get(position));
                    startActivity(intent);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }



}
