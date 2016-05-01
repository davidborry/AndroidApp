package com.polytech.si3.mypolytech;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;


import com.polytech.si3.mypolytech.adapter.WebFragmentPagerAdapter;
import com.polytech.si3.mypolytech.css.CSSBuilder;
import com.polytech.si3.mypolytech.fragment.WebFragment;
import com.polytech.si3.mypolytech.storage.Copy;

import java.io.IOException;

/**
 * Created by david on 14/04/2016.
 */
public class CampusActivity extends BackActivity  {

    private String campus1 = "campus1.html";
    private String campus2 = "campus2.html";
    private String campus3 = "campus3.html";
    private String[] campushtml = {campus1,campus2,campus3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        getSupportActionBar().setTitle("Campus");

        try{
            copyCampusFiles();
            CSSBuilder css = new CSSBuilder(this);
            css.build("article.css");
        }

        catch(Exception e){
            Log.e("STORAGEERROR:",e.toString());
        }
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        WebFragment.setUrlCategory("file:///data/data/com.example.david.polynews2/html/campus/campus");
        WebFragmentPagerAdapter.setCampusTabTitles();

        viewPager.setAdapter(new WebFragmentPagerAdapter(getSupportFragmentManager(), CampusActivity.this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void copyCampusFiles() throws IOException{

        Copy.mkdir("html/campus");
        for(int i = 0; i < campushtml.length;i++)
            Copy.store(this,"html/campus/"+campushtml[i],"html/campus/"+campushtml[i]);
    }
}
