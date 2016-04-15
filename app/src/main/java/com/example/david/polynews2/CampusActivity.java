package com.example.david.polynews2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.example.david.polynews2.adapter.WebFragmentPagerAdapter;

import org.w3c.dom.Text;

/**
 * Created by david on 14/04/2016.
 */
public class CampusActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        TextView t = (TextView) findViewById(R.id.testText);
        t.setText("sfddsf");

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new WebFragmentPagerAdapter(getSupportFragmentManager(), CampusActivity.this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
      //  tabLayout.setupWithViewPager(viewPager);
    }
}
