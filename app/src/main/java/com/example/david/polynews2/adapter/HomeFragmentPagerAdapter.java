package com.example.david.polynews2.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.david.polynews2.fragment.HomeFragment;
import com.example.david.polynews2.fragment.MenuFragment;

/**
 * Created by david on 19/04/2016.
 */
public class HomeFragmentPagerAdapter extends FragmentPagerAdapter{

    private static int PAGE_COUNT = 2;
    private static String tabTitles[] = new String[] { "ACCUEIL", "MENU"};
    protected Context context;

    public HomeFragmentPagerAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return HomeFragment.newInstance(position + 1);

            case 1:
                return MenuFragment.newInstance(position+1);

        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
