package com.bwie.test.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bwie.test.R;
import com.bwie.test.act.SelfInfoShowActivity;
import com.bwie.test.act.WebShowInfo;
import com.bwie.test.bean.AllInfoBean;
import com.bwie.test.holder.FirstTypeViewHolder;
import com.bwie.test.holder.FiveTypeViewHolder;
import com.bwie.test.holder.FourTypeViewHolder;
import com.bwie.test.holder.SecondTypeViewHolder;
import com.bwie.test.holder.SixTypeViewHolder;
import com.bwie.test.holder.ThirdTypeViewHolder;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/22 19:08
 */

public class HomePageAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final AllInfoBean allInfoBean;
    private static final int FIRST_TYPE=0;
    private static final int SECOND_TYPE=1;
    private static final int THIRD_TYPE=2;
    private static final int FOUR_TYPE=3;
    private static final int FIVE_TYPE=4;
    private static final int SIX_TYPE=5;
    private int type=0;
    public HomePageAdapter(Context context, AllInfoBean allInfoBean) {
        this.context=context;
        this.allInfoBean=allInfoBean;
    }

   

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        switch (viewType){
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.first_type_home, parent, false);
                viewHolder=new FirstTypeViewHolder(view);
                break;
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.second_type_home, parent, false);
                viewHolder=new SecondTypeViewHolder(view1);
                break;
            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.third_type_home, parent, false);
                viewHolder=new ThirdTypeViewHolder(view2);
                break;
            case 3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.four_type_home, parent, false);
                viewHolder=new FourTypeViewHolder(view3);
                break;
            case 4:
                View view4 = LayoutInflater.from(context).inflate(R.layout.five_type_home, parent, false);
                viewHolder=new FiveTypeViewHolder(view4);
                break;
            case 5:
                View view5 = LayoutInflater.from(context).inflate(R.layout.six_type_home, parent, false);
                viewHolder=new SixTypeViewHolder(view5);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                final List<AllInfoBean.DataBean.Ad1Bean> ad1Been= allInfoBean.getData().getAd1();
                FirstTypeViewHolder firstTypeViewHolder= (FirstTypeViewHolder) holder;
                firstTypeViewHolder.setBanner_iv(ad1Been,context);
               
                break;
            case 1:
                List<AllInfoBean.DataBean.Ad5Bean> ad5Been=allInfoBean.getData().getAd5();
                SecondTypeViewHolder secondTypeViewHolder= (SecondTypeViewHolder) holder;
                secondTypeViewHolder.secondType(ad5Been,context);
                
                break;
            case 2:
                ThirdTypeViewHolder thirdTypeViewHolder= (ThirdTypeViewHolder) holder;
                thirdTypeViewHolder.setHotView(allInfoBean,context);
                thirdTypeViewHolder.hotTitle.setText("๑۩۩.. "+allInfoBean.getData().getBestSellers().get(0).getName()+" ..۩۩๑");
               
                break;
            case 3:
                List<AllInfoBean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoListBeen=allInfoBean.getData().getActivityInfo().getActivityInfoList();
                FourTypeViewHolder fourTypeViewHolder= (FourTypeViewHolder) holder;
                fourTypeViewHolder.setViewPager(activityInfoListBeen,context);
                fourTypeViewHolder.preferentialTitle.setText("๑..优惠活动..๑");
                break;
            case 4:
                FiveTypeViewHolder fiveTypeViewHolder= (FiveTypeViewHolder) holder;
                fiveTypeViewHolder.setHotView(allInfoBean,context);
                fiveTypeViewHolder.hotseminar.setText("-- 热门专题 --");
                
                break;
            case 5:
                SixTypeViewHolder sixTypeViewHolder= (SixTypeViewHolder) holder;
                sixTypeViewHolder.setHotView(allInfoBean,context);
               
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                type=FIRST_TYPE;
                break;
            case 1:
                type=SECOND_TYPE;
                break;
            case 2:
                type=THIRD_TYPE;
                break;
            case 3:
                type=FOUR_TYPE;
                break;
            case 4:
                type=FIVE_TYPE;
                break;
            case 5:
                type=SIX_TYPE;
                break;
            
        }
        return type;
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
