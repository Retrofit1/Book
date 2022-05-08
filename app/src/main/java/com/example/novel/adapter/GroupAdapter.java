package com.example.novel.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novel.Book;
import com.example.novel.R;

import java.util.ArrayList;
import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {
    private final Activity activity;
    List<Book>bookList;

   public GroupAdapter(Activity activity, List<Book> bookList){
        this.activity=activity;
        this.bookList=bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_group,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.tvName.setText(position+"");
        Book book=bookList.get(position);
        ArrayList<String>arrayListMember = new ArrayList<>();
        
            arrayListMember.add("书名: "+book.getBookName());
            arrayListMember.add("简介: "+book.getBookDesc());
            arrayListMember.add("作者: "+book.getAuthorName());

        MemberAdapter adapterMember = new MemberAdapter(arrayListMember);
        //Initialize layout manager
        LinearLayoutManager layoutManagerMember = new LinearLayoutManager(activity);
        //Set layout manager
        holder.rvMember.setLayoutManager(layoutManagerMember);
        //Set adapter
        holder.rvMember.setAdapter(adapterMember);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView tvName;
        RecyclerView rvMember;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tv_name);
            rvMember=itemView.findViewById(R.id.rv_member);
        }
    }
}
