package com.example.david.polynews2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.david.polynews2.CampusActivity;
import com.example.david.polynews2.NewsActivity;
import com.example.david.polynews2.ProjectsActivity;
import com.example.david.polynews2.R;
import com.example.david.polynews2.TestActivity;

/**
 * Created by david on 14/04/2016.
 */
public class MenuFragment extends Fragment {

    private ImageButton test;
    private ImageButton campusButton;
    private ImageButton newsButton;

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
    }
}
