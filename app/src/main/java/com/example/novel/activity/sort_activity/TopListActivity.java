package com.example.novel.activity.sort_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.novel.R;
import com.example.novel.adapter.TopListAdapter;
import com.example.novel.tabs.TopListOneFragment;
import com.example.novel.tabs.TopListTwoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class TopListActivity extends AppCompatActivity {

    private TabLayout topListTable;
    private ViewPager topListPager;

    private TopListOneFragment topListOneFragment;
    private TopListTwoFragment topListTwoFragment;
    private TopListAdapter topListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_list);

        topListPager=findViewById(R.id.view_TopListPager);
        topListTable=findViewById(R.id.tab_topListLayout);
        topListOneFragment=new TopListOneFragment();
        topListTwoFragment=new TopListTwoFragment();
        topListTable.setupWithViewPager(topListPager);

        topListAdapter=new TopListAdapter(getSupportFragmentManager());


        topListAdapter.addFragment(topListOneFragment,"七日在读榜");
        topListAdapter.addFragment(topListTwoFragment,"七日上升榜");
        topListPager.setAdapter(topListAdapter);


        topListTable.setupWithViewPager(topListPager);
    }

}