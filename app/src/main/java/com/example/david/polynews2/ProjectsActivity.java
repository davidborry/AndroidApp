package com.example.david.polynews2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.david.polynews2.adapter.VideoFragmentPagerAdapter;
import com.example.david.polynews2.adapter.VideosCustomAdapter;

/**
 * Created by david on 19/04/2016.
 */
public class ProjectsActivity extends BackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        try{
            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager3);
            VideoFragmentPagerAdapter mSectionsPagerAdapter = new VideoFragmentPagerAdapter(getSupportFragmentManager());

            viewPager.setAdapter(mSectionsPagerAdapter);

          //  TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs3);

        }

        catch(Exception e){
            Log.e("FRAGMENTERROR: ", e.toString());
        }
    }
}
