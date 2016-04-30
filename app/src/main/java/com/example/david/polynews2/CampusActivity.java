package com.example.david.polynews2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


import com.example.david.polynews2.adapter.WebFragmentPagerAdapter;
import com.example.david.polynews2.css.CSSBuilder;
import com.example.david.polynews2.fragment.WebFragment;
import com.example.david.polynews2.storage.Copy;

import org.w3c.dom.Text;

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
