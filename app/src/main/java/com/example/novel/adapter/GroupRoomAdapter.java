package com.example.novel.adapter;



import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novel.R;
import com.example.novel.mode.MemberUrlImage;

import java.util.ArrayList;



public class GroupRoomAdapter extends RecyclerView.Adapter<GroupRoomAdapter.GroupRoomViewHolder> {
    private Activity activity;
    ArrayList<MemberUrlImage>memberUrlImageArrayList;
    ArrayList<String >arrayListGroupRoom;
    public GroupRoomAdapter(Activity activity,ArrayList<String> arrayListGroupRoom,ArrayList<MemberUrlImage> memberUrlImageArrayList){
        this.activity=activity;
        this.arrayListGroupRoom=arrayListGroupRoom;
        this.memberUrlImageArrayList=memberUrlImageArrayList;

    }


    @NonNull
    @Override
    public GroupRoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_roomgroup,parent,false);
        return new GroupRoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupRoomViewHolder holder, int position) {
        holder.imageView.setImageResource((memberUrlImageArrayList.get(position).getMemberImage()));
        holder.rvRoomName.setText(arrayListGroupRoom.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayListGroupRoom.size();
    }

    public class GroupRoomViewHolder extends RecyclerView.ViewHolder {

        TextView rvRoomName;
        ImageView imageView;
        public GroupRoomViewHolder(@NonNull View itemView) {
            super(itemView);
            rvRoomName=itemView.findViewById(R.id.tv_roomName);
            imageView=itemView.findViewById(R.id.iv_image);
        }
    }
}
