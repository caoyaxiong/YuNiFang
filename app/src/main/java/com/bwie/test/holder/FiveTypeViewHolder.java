package com.bwie.test.holder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.test.R;
import com.bwie.test.adapter.HotSeminarAdapter;
import com.bwie.test.adapter.RfiveItemAdapter;
import com.bwie.test.adapter.RhotAdapter;
import com.bwie.test.bean.AllInfoBean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/23 19:30
 */

public class FiveTypeViewHolder extends RecyclerView.ViewHolder {

    public final TextView hotseminar;
    public final RecyclerView recyclerView;
    public final LinearLayout linearLayout;
    public FiveTypeViewHolder(View itemView) {
        super(itemView);
        hotseminar = (TextView) itemView.findViewById(R.id.hotseminar);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerViewHot);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.hot_item);
    }
    public void setHotView(AllInfoBean allInfoBean, Context context){
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        HotSeminarAdapter adapter=new HotSeminarAdapter(context,allInfoBean);
        recyclerView.setAdapter(adapter);
    }
}
