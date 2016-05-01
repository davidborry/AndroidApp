package com.polytech.si3.mypolytech.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.polytech.si3.mypolytech.fragment.VideosListFragment;

/**
 * Created by david on 19/04/2016.
 */
public class VideoFragmentPagerAdapter extends FragmentPagerAdapter{

    public VideoFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return VideosListFragment.newInstance();

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
              return "Vidéos";
        }
        return null;
    }
}

