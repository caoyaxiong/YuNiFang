package com.bwie.test.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bwie.test.R;
import com.bwie.test.act.SelfInfoShowActivity;
import com.bwie.test.bean.AllInfoBean;
import com.bwie.test.holder.RsixHolder;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/23 19:49
 */
public class RsixAdapter extends RecyclerView.Adapter<RsixHolder> {

    private final Context context;
    private final AllInfoBean allInfoBean;


    public RsixAdapter(Context context,AllInfoBean allInfoBean) {
        this.context=context;
        this.allInfoBean=allInfoBean;
    }

    //关联相应的viewHolder
    @Override
    public RsixHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.six_item, parent, false);
        RsixHolder rhotHolder=new RsixHolder(view);
        return rhotHolder;
    }
    //设置每个条目的数据
    @Override
    public void onBindViewHolder(RsixHolder holder, final int position) {
        holder.text_hot.setText(allInfoBean.getData().getDefaultGoodsList().get(position).getEfficacy());
        holder.hot_tv.setText(allInfoBean.getData().getDefaultGoodsList().get(position).getGoods_name());
        holder.now_price.setText("￥"+allInfoBean.getData().getDefaultGoodsList().get(position).getShop_price());
        holder.old_price.setText("￥"+allInfoBean.getData().getDefaultGoodsList().get(position).getMarket_price());
        holder.old_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
        Glide.with(context)
                .load(allInfoBean.getData().getDefaultGoodsList().get(position).getGoods_img())
                .into(holder.hot_iv);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SelfInfoShowActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("bean",allInfoBean);
                intent.putExtra("itemViewType",0);
                context.startActivity(intent);
            }
        });
    }
    //
    @Override
    public int getItemCount() {
        return allInfoBean.getData().getDefaultGoodsList().size();
    }
}
