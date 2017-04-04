package com.bwie.test.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bwie.test.R;
import com.bwie.test.bean.AllInfoBean;
import com.bwie.test.holder.FiveTypeViewHolder;
import com.bwie.test.holder.HotSeminarHolder;
import com.bwie.test.holder.RhotHolder;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/25 10:39
 */

public class HotSeminarAdapter extends RecyclerView.Adapter<HotSeminarHolder>{

    private final Context context;
    private final AllInfoBean allInfoBean;



    public HotSeminarAdapter(Context context, AllInfoBean allInfoBean) {
        this.context=context;
        this.allInfoBean=allInfoBean;
    }

    //关联相应的viewHolder
    @Override
    public HotSeminarHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.five_holder_item, parent, false);
        HotSeminarHolder rhotHolder=new HotSeminarHolder(view);
        return rhotHolder;
    }
    //设置每个条目的数据
    @Override
    public void onBindViewHolder(HotSeminarHolder holder, int position) {
        holder.setZhuanti(allInfoBean,context);
        Glide.with(context)
                .load(allInfoBean.getData().getSubjects().get(position).getImage())
                .into(holder.zhuanti);
    }
    //
    @Override
    public int getItemCount() {
        return allInfoBean.getData().getSubjects().size();
    }
}