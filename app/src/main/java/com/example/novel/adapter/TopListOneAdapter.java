package com.example.novel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.novel.R;

import java.util.ArrayList;

public class TopListOneAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;


    int[] icons = {R.drawable.toplist, R.drawable.newbook,
            R.drawable.readinglab, R.drawable.mystory};

    public TopListOneAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return icons.length;

    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.itemtoplist, null);
            holder = new ViewHolder();
            holder.gvImage = convertView.findViewById(R.id.iv_iconTopList);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.gvImage.setImageResource(icons[position]);

        return convertView;
    }

    static class ViewHolder {
        public ImageView gvImage;

    }
}
