package com.bwie.test.holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.test.R;
import com.bwie.test.act.WebShowInfo;
import com.bwie.test.adapter.HomePageAdapter;
import com.bwie.test.bean.AllInfoBean;
import com.bwie.test.utils.GlideImageLoader;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/22 19:09
 */

public class SecondTypeViewHolder extends RecyclerView.ViewHolder {

    public final ImageView image1;
    public final ImageView image2;
    public final ImageView image3;
    public final ImageView image4;
    public final TextView text1;
    public final TextView text2;
    public final TextView text3;
    public final TextView text4;
    public final List<ImageView> imageViewList;
    public final List<TextView> textViewList;
    public final LinearLayout ll1,ll2,ll3,ll4;
    public final List<LinearLayout> ll;
    public SecondTypeViewHolder(View itemView) {
        super(itemView);
        image1 = (ImageView) itemView.findViewById(R.id.ad5_image1);
        image2 = (ImageView) itemView.findViewById(R.id.ad5_image2);
        image3 = (ImageView) itemView.findViewById(R.id.ad5_image3);
        image4 = (ImageView) itemView.findViewById(R.id.ad5_image4);
        text1 = (TextView) itemView.findViewById(R.id.ad5_text1);
        text2 = (TextView) itemView.findViewById(R.id.ad5_text2);
        text3 = (TextView) itemView.findViewById(R.id.ad5_text3);
        text4 = (TextView) itemView.findViewById(R.id.ad5_text4);
        imageViewList = new ArrayList<>();
        imageViewList.add(image1);
        imageViewList.add(image2);
        imageViewList.add(image3);
        imageViewList.add(image4);
        textViewList = new ArrayList<>();
        textViewList.add(text1);
        textViewList.add(text2);
        textViewList.add(text3);
        textViewList.add(text4);
        ll=new ArrayList<>();
        ll1 = (LinearLayout) itemView.findViewById(R.id.ll1);
        ll2= (LinearLayout) itemView.findViewById(R.id.ll2);
        ll3= (LinearLayout) itemView.findViewById(R.id.ll3);
        ll4= (LinearLayout) itemView.findViewById(R.id.ll4);
        ll.add(ll1);
        ll.add(ll2);
        ll.add(ll3);
        ll.add(ll4);
    }
   public void secondType(final List<AllInfoBean.DataBean.Ad5Bean>list, final Context context){
       for (int i = 0; i < list.size(); i++) {
           Glide.with(context)
                   .load(list.get(i).getImage())
                   .into(imageViewList.get(i));
           textViewList.get(i).setText(list.get(i).getTitle());
          
       }
       ll1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String url=list.get(0).getAd_type_dynamic_data();
               Intent intent=new Intent(context, WebShowInfo.class);
               intent.putExtra("url",url);
               context.startActivity(intent);
           }
       });
       ll2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String url=list.get(1).getAd_type_dynamic_data();
               Intent intent=new Intent(context, WebShowInfo.class);
               intent.putExtra("url",url);
               context.startActivity(intent);
           }
       });
       ll3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String url=list.get(2).getAd_type_dynamic_data();
               Intent intent=new Intent(context, WebShowInfo.class);
               intent.putExtra("url",url);
               context.startActivity(intent);
           }
       });
       ll4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String url=list.get(3).getAd_type_dynamic_data();
               Intent intent=new Intent(context, WebShowInfo.class);
               intent.putExtra("url",url);
               context.startActivity(intent);
           }
       });
   }

}
