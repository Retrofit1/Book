package com.example.novel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novel.R;
import com.example.novel.adapter.GroupRoomAdapter;
import com.example.novel.mode.MemberUrlImage;

import java.util.ArrayList;


public class MeFragment extends Fragment {
    RecyclerView rvGroupRoom;
    ArrayList<String> arrayListGroupRoom;
    ArrayList<MemberUrlImage> memberUrlImageArrayList;
    LinearLayoutManager linearLayoutManager;
    GroupRoomAdapter adapterRoomGroup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.me_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvGroupRoom=view.findViewById(R.id.rv_groupRoom);
        initTextData();
        initImageData();
        adapterRoomGroup = new GroupRoomAdapter(getActivity(),arrayListGroupRoom,memberUrlImageArrayList);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvGroupRoom.setLayoutManager(linearLayoutManager);
        rvGroupRoom.setAdapter(adapterRoomGroup);

    }
    private void initImageData(){
        memberUrlImageArrayList=new ArrayList<>();
        memberUrlImageArrayList.add(new MemberUrlImage(R.drawable.mystory));
        memberUrlImageArrayList.add(new MemberUrlImage(R.drawable.newbook));
        memberUrlImageArrayList.add(new MemberUrlImage(R.drawable.readinglab));
        memberUrlImageArrayList.add(new MemberUrlImage(R.drawable.mystory));
        memberUrlImageArrayList.add(new MemberUrlImage(R.drawable.newbook));
        memberUrlImageArrayList.add(new MemberUrlImage(R.drawable.readinglab));
    }
    private void initTextData(){
        arrayListGroupRoom=new ArrayList<>();
        for(int i=1;i<=6;i++){
            arrayListGroupRoom.add("Group" + i);
        }
    }
}
