package com.example.novel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novel.R;
import com.example.novel.mode.DiscountedProducts;

import java.util.ArrayList;
import java.util.List;


public class DiscountedProductAdapter extends RecyclerView.Adapter<DiscountedProductAdapter.DiscountedProductViewHolder> {

    Context context;
  List<DiscountedProducts>discountedProductsList;

    public DiscountedProductAdapter(Context context, ArrayList<DiscountedProducts> discountedProductsList) {
        this.context=context;
        this.discountedProductsList=discountedProductsList;
    }

    @NonNull
    @Override
    public DiscountedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discounted_row_items,parent,false);
        return new DiscountedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedProductViewHolder holder, int position) {

        holder.discountedImageView.setImageResource((discountedProductsList.get(position).getImageurl()));
    }

    @Override
    public int getItemCount() {
        return discountedProductsList.size();
    }

    public static class DiscountedProductViewHolder extends RecyclerView.ViewHolder {
        ImageView discountedImageView;
        public DiscountedProductViewHolder(@NonNull View itemView) {
            super(itemView);
            discountedImageView = itemView.findViewById(R.id.discountedImage);
        }
    }
}
