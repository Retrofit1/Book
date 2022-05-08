package com.example.novel.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.novel.R;
import com.example.novel.adapter.TopListOneAdapter;

import java.util.ArrayList;

public class TopListOneFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private GridView topListGridView;
    private TextView BookName;
    private ArrayList<String>BookNameArrayList;
    public TopListOneFragment() {
    }

    public static TopListOneFragment newInstance(String param1, String param2) {
        TopListOneFragment fragment = new TopListOneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_list_one, container, false);
        topListGridView=view.findViewById(R.id.TopListGridView);

        topListGridView.setAdapter(new TopListOneAdapter(getActivity()));
        return view;
    }
//    public void initData(){
//        BookNameArrayList=new ArrayList<>();
//        BookNameArrayList.add("云边有个小卖铺");
//        BookNameArrayList.add("挪威的森林");
//        BookNameArrayList.add("小王子");
//        BookNameArrayList.add("解忧杂货铺");
//        BookNameArrayList.add("平凡人生");
//        BookNameArrayList.add("挪威的森林");
//    }
}