package com.bwie.test.holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.test.R;
import com.bwie.test.act.WebShowInfo;
import com.bwie.test.adapter.RhotAdapter;
import com.bwie.test.bean.AllInfoBean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/23 19:30
 */

public class ThirdTypeViewHolder extends RecyclerView.ViewHolder {

    public final TextView hotTitle;
    public final RecyclerView recyclerView;
    

    public ThirdTypeViewHolder(View itemView) {
        super(itemView);
        
        hotTitle = (TextView) itemView.findViewById(R.id.hotTitle);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerViewHot);
    }
    public void setHotView(AllInfoBean allInfoBean, Context context){
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        RhotAdapter adapter=new RhotAdapter(context,allInfoBean);
        recyclerView.setAdapter(adapter);
     
    }
}
