package com.all.play.miultyitemshow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.all.play.miultyitemshow.R;
import com.all.play.miultyitemshow.entrity.MenuEntity;

import java.util.List;

import me.yokeyword.indexablerv.IndexableHeaderAdapter;

/**
 * Created by 聪明一只哈 on 2018/4/27.
 * Time: 2018/4/27  13:42
 */

public class MenuHeaderAdapter extends IndexableHeaderAdapter<MenuEntity> {
    private static final int TYPE = 1;
    private Context context;

    public MenuHeaderAdapter(Context context,String index, String indexTitle, List<MenuEntity> datas) {
        super(index, indexTitle, datas);
        this.context = context;
    }

    @Override
    public int getItemViewType() {
        return TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        return new VH(LayoutInflater.from(context).inflate(R.layout.header_contact_menu, parent, false));
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, MenuEntity entity) {
        VH vh = (VH) holder;
        vh.tv.setText(entity.getMenuTitle());
        vh.img.setImageResource(entity.getMenuIconRes());
    }

    private class VH extends RecyclerView.ViewHolder {
        private TextView tv;
        private ImageView img;

        public VH(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_title);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
