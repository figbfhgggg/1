package com.example.alexander.kurs_4_1.main.mainScreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.alexander.kurs_4_1.main.entryScreen.EntryScreenFragment;
import com.example.alexander.kurs_4_1.main.formScreen.SelectionScreenFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SelectionScreenFragment tab1 = new SelectionScreenFragment();
                return tab1;
            case 1:
                EntryScreenFragment tab2 = new EntryScreenFragment();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}