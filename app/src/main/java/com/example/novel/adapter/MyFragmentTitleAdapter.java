package com.example.novel.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentTitleAdapter extends FragmentPagerAdapter {
    private List<String >mTitleList;
    private List<Fragment>mFragmentList;
    public MyFragmentTitleAdapter(@NonNull FragmentManager fm,
                                  List<Fragment>fragmentList,
                                  List<String>titleList) {
        super(fm);
        this.mFragmentList=fragmentList;
        this.mTitleList=titleList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList==null ? null : mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList==null ? 0 : mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList==null ? "" : mTitleList.get(position);
    }
}
