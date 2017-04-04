package com.bwie.test.holder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.test.R;
import com.bwie.test.adapter.RfiveItemAdapter;
import com.bwie.test.adapter.RhotAdapter;
import com.bwie.test.bean.AllInfoBean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/25 10:40
 */

public class HotSeminarHolder extends RecyclerView.ViewHolder {

    public final ImageView zhuanti;

    public final RecyclerView recyclerView;

    public HotSeminarHolder(View itemView) {
        super(itemView);
        zhuanti = (ImageView) itemView.findViewById(R.id.zhuanti);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
    }
    public void setZhuanti(AllInfoBean allInfoBean, Context context){
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        RfiveItemAdapter adapter=new RfiveItemAdapter(context,allInfoBean);
        recyclerView.setAdapter(adapter);
        
    }
}
