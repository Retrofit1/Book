package com.example.novel.fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.novel.R;
import com.example.novel.activity.SearchActivity;
import com.example.novel.activity.sort_activity.TopListActivity;
import com.example.novel.adapter.ImageAdapter;


public class SortFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.sort_fragment,container,false);

       GridView gridView=view.findViewById(R.id.gridview);
       GridView gridView1=view.findViewById(R.id.gridview1);
       gridView.setAdapter(new ImageAdapter(getActivity()));
       gridView1.setAdapter(new ImageAdapter(getActivity()));

       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             switch (i){
                 case 0:
                     Intent intent1=new Intent(getContext(), TopListActivity.class);
                     startActivity(intent1);
                     break;
             }
           }
       });
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),"点击了第"+i+"个",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button search=view.findViewById(R.id.btn_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}
