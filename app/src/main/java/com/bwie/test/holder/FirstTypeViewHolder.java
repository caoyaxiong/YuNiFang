package com.bwie.test.holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.test.R;
import com.bwie.test.act.WebShowInfo;
import com.bwie.test.bean.AllInfoBean;
import com.bwie.test.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/22 19:09
 */

public class FirstTypeViewHolder extends RecyclerView.ViewHolder {

    public final Banner banner_iv;

    public FirstTypeViewHolder(View itemView) {
        super(itemView);
        banner_iv = (Banner) itemView.findViewById(R.id.banner_iv);
    }
    public void setBanner_iv(final List<AllInfoBean.DataBean.Ad1Bean> list, final Context context){
        List<String> lv = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            lv.add(list.get(i).getImage());
        }
        banner_iv.setImages(lv).setImageLoader(new GlideImageLoader()).start();
        banner_iv.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                String url=list.get(position).getAd_type_dynamic_data();
                Intent intent=new Intent(context, WebShowInfo.class);
                intent.putExtra("url",url);
                context.startActivity(intent);
            }
        });
    }
}
