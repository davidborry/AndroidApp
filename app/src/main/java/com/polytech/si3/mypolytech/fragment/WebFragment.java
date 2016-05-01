package com.polytech.si3.mypolytech.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.polytech.si3.mypolytech.R;

/**
 * Created by david on 16/04/2016.
 */
public class WebFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private static String URL = "#";

    private int mPage;

    public static WebFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        WebFragment fragment = new WebFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        WebView web = (WebView) view;
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);

        web.loadUrl(URL+mPage+".html");
        return view;
    }

    public static void setUrlCategory(String URL2){
        URL=URL2;
    }

    public static String getCurrentURLCategory(){
        return URL;
    }
}
