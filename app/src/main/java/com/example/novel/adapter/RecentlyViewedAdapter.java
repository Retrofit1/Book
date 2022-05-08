package com.example.novel.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novel.R;
import com.example.novel.activity.ProductDetails;
import com.example.novel.mode.RecentlyViewed;

import java.util.ArrayList;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewHolder> {
    Context context;
    ArrayList<RecentlyViewed>recentlyViewedArrayList;

    public RecentlyViewedAdapter(Context context, ArrayList<RecentlyViewed> recentlyViewedDataArrayList) {
        this.context=context;
        this.recentlyViewedArrayList=recentlyViewedDataArrayList;
    }

    @NonNull
    @Override
    public RecentlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_items,parent,false);
        return new RecentlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewHolder holder, int position) {
        holder.name.setText(recentlyViewedArrayList.get(position).getName());
        holder.description.setText(recentlyViewedArrayList.get(position).getDescription());
        holder.price.setText(recentlyViewedArrayList.get(position).getPrice());
        holder.qty.setText(recentlyViewedArrayList.get(position).getQuantity());
        holder.unit.setText(recentlyViewedArrayList.get(position).getUnit());
        holder.name.setText(recentlyViewedArrayList.get(position).getName());
        holder.bg.setBackgroundResource(recentlyViewedArrayList.get(position).getImageUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, ProductDetails.class);
                intent.putExtra("name",recentlyViewedArrayList.get(position).getName());
                intent.putExtra("image",recentlyViewedArrayList.get(position).getBigimagerurl());
                intent.putExtra("price",recentlyViewedArrayList.get(position).getPrice());
                intent.putExtra("desc",recentlyViewedArrayList.get(position).getDescription());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recentlyViewedArrayList.size();
    }

    public class RecentlyViewHolder extends RecyclerView.ViewHolder {
        TextView name,description,price,qty,unit;
        ConstraintLayout bg;
        public RecentlyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.product_name);
            description=itemView.findViewById(R.id.description);
            price=itemView.findViewById(R.id.price);
            qty=itemView.findViewById(R.id.qty);
            bg=itemView.findViewById(R.id.recently_layout);
            unit=itemView.findViewById(R.id.unit);

        }
    }
}
