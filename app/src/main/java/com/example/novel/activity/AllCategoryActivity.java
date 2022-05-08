package com.example.novel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.novel.R;
import com.example.novel.adapter.AllCategoryAdapter;
import com.example.novel.mode.AllCategoryModel;
import com.example.novel.tabs.FollwFragment;

import java.util.ArrayList;


public class AllCategoryActivity extends AppCompatActivity {

    RecyclerView AllCategoryRecycler;
    AllCategoryAdapter AllCategoryAdapter;
    ImageView back;

    private ArrayList<AllCategoryModel> allCategoryModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        AllCategoryRecycler=findViewById(R.id.allCategory);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllCategoryActivity.this, FollwFragment.class);
                intent.putExtra("id",1);
                startActivity(intent);
                finish();
            }
        });

        initData();
        AllCategoryRecycler(allCategoryModelList);
    }
    private void AllCategoryRecycler(ArrayList<AllCategoryModel>allCategoryModelList) {
        RecyclerView.LayoutManager layoutManager =new GridLayoutManager(this,3);
        AllCategoryRecycler.setLayoutManager(layoutManager);
        AllCategoryAdapter = new AllCategoryAdapter(this,allCategoryModelList);
        AllCategoryRecycler.setAdapter(AllCategoryAdapter);
    }
    private void initData(){
        allCategoryModelList = new ArrayList<>();
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.mystory));
        allCategoryModelList.add(new AllCategoryModel(2,R.drawable.newbook));
        allCategoryModelList.add(new AllCategoryModel(3,R.drawable.readinglab));
        allCategoryModelList.add(new AllCategoryModel(4,R.drawable.mystory));
        allCategoryModelList.add(new AllCategoryModel(5,R.drawable.newbook));
        allCategoryModelList.add(new AllCategoryModel(6,R.drawable.readinglab));
    }
}