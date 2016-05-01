package com.polytech.si3.mypolytech.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.polytech.si3.mypolytech.AboutActivity;
import com.polytech.si3.mypolytech.AssosActivity;
import com.polytech.si3.mypolytech.CampusActivity;
import com.polytech.si3.mypolytech.EventsActivity;
import com.polytech.si3.mypolytech.MapsActivity;
import com.polytech.si3.mypolytech.NewsActivity;
import com.polytech.si3.mypolytech.ProjectsActivity;
import com.polytech.si3.mypolytech.R;
import com.polytech.si3.mypolytech.TwitterActivity;

/**
 * Created by david on 14/04/2016.
 */
public class MenuFragment extends Fragment {

    private ImageButton test;
    private ImageButton campusButton;
    private ImageButton newsButton;
    private ImageButton mapButton;
    private ImageButton eventButton;
    private ImageButton twitterButton;
    private ImageButton assosButton;
    private ImageButton aboutButton;

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    private View.OnClickListener testClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), ProjectsActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener campusClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), CampusActivity.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener newsClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), NewsActivity.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener mapClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), MapsActivity.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener eventClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), EventsActivity.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener twitterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), TwitterActivity.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener assosClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), AssosActivity.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener aboutClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), AboutActivity.class);
            startActivity(intent);
        }
    };

    public static MenuFragment newInstance(int page){
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        MenuFragment fragment = new MenuFragment();
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
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        initializeButtons(view);
        return view;
    }

    public void initializeButtons(View v){
        test = (ImageButton) v.findViewById(R.id.testApp);
        test.setOnClickListener(testClick);

        campusButton = (ImageButton) v.findViewById(R.id.campusButton);
        campusButton.setOnClickListener(campusClick);

        newsButton = (ImageButton) v.findViewById(R.id.newsButton);
        newsButton.setOnClickListener(newsClick);

        mapButton = (ImageButton) v.findViewById(R.id.mapButton);
        mapButton.setOnClickListener(mapClick);

        eventButton = (ImageButton) v.findViewById(R.id.eventsButton);
        eventButton.setOnClickListener(eventClick);

        twitterButton = (ImageButton) v.findViewById(R.id.twitterButton);
        twitterButton.setOnClickListener(twitterClick);

        assosButton = (ImageButton) v.findViewById(R.id.assosButton);
        assosButton.setOnClickListener(assosClick);

        aboutButton = (ImageButton) v.findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(aboutClick);
    }
}
