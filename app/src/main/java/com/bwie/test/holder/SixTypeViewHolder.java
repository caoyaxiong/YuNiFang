package com.bwie.test.holder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.test.R;
import com.bwie.test.adapter.RhotAdapter;
import com.bwie.test.adapter.RsixAdapter;
import com.bwie.test.bean.AllInfoBean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/23 19:30
 */

public class SixTypeViewHolder extends RecyclerView.ViewHolder {

    public final RecyclerView recyclerView;
    public final LinearLayout linearLayout;
    public SixTypeViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.grid_recy);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.six_info_item);
    }
    public void setHotView(AllInfoBean allInfoBean, Context context){
        recyclerView.setLayoutManager(new GridLayoutManager(context,2,LinearLayoutManager.VERTICAL,false));
        RsixAdapter adapter=new RsixAdapter(context,allInfoBean);
        recyclerView.setAdapter(adapter);
       
    }
}
