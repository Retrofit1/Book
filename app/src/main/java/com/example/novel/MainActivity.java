package com.example.novel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.novel.fragment.DeskFragment;
import com.example.novel.fragment.HomeFragment;
import com.example.novel.fragment.MeFragment;
import com.example.novel.fragment.SortFragment;
import com.example.novel.tabs.FollwFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;



public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int id;
    private FollwFragment follwFragment;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNav);

        //有待改进
        id=getIntent().getIntExtra("id",0);
        if(id==1){
            getSupportFragmentManager().beginTransaction().add(R.layout.activity_all_category,follwFragment).show(follwFragment).commit();
        }

        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.desk:
                        fragment =new DeskFragment();
                        break;
                    case R.id.sort:
                        fragment = new SortFragment();
                        break;
                    case R.id.me:
                        fragment = new MeFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });
    }

}
