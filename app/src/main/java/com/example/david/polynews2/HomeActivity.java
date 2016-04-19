package com.example.david.polynews2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.david.polynews2.adapter.HomeFragmentPagerAdapter;

/**
 * Created by david on 19/04/2016.
 */
public class HomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        try{
            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager2);
            viewPager.setAdapter(new HomeFragmentPagerAdapter(getSupportFragmentManager(), HomeActivity.this));

            TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs2);
            tabLayout.setupWithViewPager(viewPager);
        }

        catch (Exception e){
            Log.e("FRAGMENTERROR: ", e.toString());
        }



    }
}
