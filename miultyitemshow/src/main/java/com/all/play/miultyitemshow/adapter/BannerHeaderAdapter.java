package com.all.play.miultyitemshow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.all.play.miultyitemshow.R;
import com.all.play.miultyitemshow.utils.ToastUtil;

import java.util.List;

import me.yokeyword.indexablerv.IndexableHeaderAdapter;

/**
 * Created by 聪明一只哈 on 2018/4/27.
 * Time: 2018/4/27  13:46
 */

public class BannerHeaderAdapter extends IndexableHeaderAdapter {
    private static final int TYPE = 2;
    private Context context;

    public BannerHeaderAdapter(Context context, String index, String indexTitle, List datas) {
        super(index, indexTitle, datas);
        this.context = context;
    }

    @Override
    public int getItemViewType() {
        return TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.header_contact_banner, parent, false);
        VH holder = new VH(view);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(context, "---点击了Banner---");
            }
        });
        return holder;
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, Object entity) {
        // 数据源为null时, 该方法不用实现
    }

    private class VH extends RecyclerView.ViewHolder {
        ImageView img;

        public VH(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
