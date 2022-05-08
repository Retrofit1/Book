package com.example.novel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novel.R;
import com.example.novel.activity.AllCategoryActivity;
import com.example.novel.mode.AllCategoryModel;

import java.util.ArrayList;


public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder> {
    Context context;
    ArrayList<AllCategoryModel> allCategoryModelArrayList;

    public AllCategoryAdapter(Context context, ArrayList<AllCategoryModel> allCategoryModelArrayList) {
        this.context=context;
        this.allCategoryModelArrayList=allCategoryModelArrayList;
    }

    public AllCategoryAdapter(AllCategoryActivity context, ArrayList<AllCategoryModel> allCategoryModelList) {
    }

    @NonNull
    @Override
    public AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_category_row_items,parent,false);

        return new AllCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHolder holder, int position) {
        holder.categoryImage.setImageResource(allCategoryModelArrayList.get(position).getImageurl());
    }

    @Override
    public int getItemCount() {
        return allCategoryModelArrayList.size();
    }

    public static class AllCategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        public AllCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.categoryImage);
        }
    }
}
