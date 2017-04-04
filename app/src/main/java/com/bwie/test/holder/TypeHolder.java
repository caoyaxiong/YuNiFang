package com.bwie.test.holder;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bwie.test.R;
import com.bwie.test.adapter.RsixAdapter;
import com.bwie.test.adapter.TypeAdapter;
import com.bwie.test.bean.AllInfoBean;
import com.bwie.test.bean.GongXiao;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/23 19:30
 */

public class TypeHolder extends RecyclerView.ViewHolder {

    public final RecyclerView recyclerView;
    public final LinearLayout linearLayout;
    public TypeHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.grid_recy);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.six_info_item);
    }
    public void setHotView(GongXiao gongXiao, Context context){
        recyclerView.setLayoutManager(new GridLayoutManager(context,2,LinearLayoutManager.VERTICAL,false));
        TypeAdapter adapter=new TypeAdapter(context,gongXiao);
        recyclerView.setAdapter(adapter);
       
    }
}
