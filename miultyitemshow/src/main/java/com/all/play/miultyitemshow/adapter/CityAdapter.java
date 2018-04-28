package com.all.play.miultyitemshow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.all.play.miultyitemshow.R;
import com.all.play.miultyitemshow.entrity.CityEntity;

import me.yokeyword.indexablerv.IndexableAdapter;

/**
 * Created by 聪明一只哈 on 2018/4/27.
 * Time: 2018/4/27  10:12
 */

public class CityAdapter extends IndexableAdapter<CityEntity> {
    private LayoutInflater mInflater;

    public CityAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_index_city, parent, false);
        return new IndexVH(view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_city, parent, false);
        return new ContentVH(view);
    }

    @Override
    public void onBindTitleViewHolder(RecyclerView.ViewHolder holder, String indexTitle) {
        IndexVH vh = (IndexVH) holder;
        vh.tv.setText(indexTitle);
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, CityEntity entity) {
        ContentVH vh = (ContentVH) holder;
        vh.tv.setText(entity.getName());
    }

    private class IndexVH extends RecyclerView.ViewHolder {
        TextView tv;

        public IndexVH(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_index);
        }
    }

    private class ContentVH extends RecyclerView.ViewHolder {
        TextView tv;

        public ContentVH(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
