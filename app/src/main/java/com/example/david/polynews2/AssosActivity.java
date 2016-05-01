package com.example.david.polynews2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.david.polynews2.adapter.WebFragmentPagerAdapter;
import com.example.david.polynews2.css.CSSBuilder;
import com.example.david.polynews2.fragment.WebFragment;
import com.example.david.polynews2.storage.Copy;

import java.io.IOException;

/**
 * Created by david on 01/05/2016.
 */
public class AssosActivity extends BackActivity {
    private String asso1 = "asso1.html";
    private String asso2 = "asso2.html";
    private String asso3 = "asso3.html";
    private String asso4 = "asso4.html";
    private String asso5 = "asso5.html";
    private String[] assosHtml = {asso1,asso2,asso3,asso4,asso5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        getSupportActionBar().setTitle("Associations");

        try{
            copyAssosFiles();
            CSSBuilder css = new CSSBuilder(this);
            css.build("article.css");
        }

        catch(Exception e){
            Log.e("STORAGEERROR:", e.toString());
        }
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        WebFragment.setUrlCategory("file:///data/data/com.example.david.polynews2/html/assos/asso");
        WebFragmentPagerAdapter.setAssosTabTitles();

        viewPager.setAdapter(new WebFragmentPagerAdapter(getSupportFragmentManager(), AssosActivity.this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void copyAssosFiles() throws IOException {

        Copy.mkdir("html/assos");
        for(int i = 0; i < assosHtml.length;i++)
            Copy.store(this,"html/assos/"+assosHtml[i],"html/assos/"+assosHtml[i]);
    }
}
