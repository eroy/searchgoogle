package com.example.searchgoogle.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.searchgoogle.ui.favourite.FavouriteFragment;
import com.example.searchgoogle.ui.search.SearchFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    static final int PAGE_COUNT = 2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Search";
            case 1:
                return "Favourite";
            default:
                return "Search";
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SearchFragment();
            case 1:
                return new FavouriteFragment();
            default:
                return new SearchFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
