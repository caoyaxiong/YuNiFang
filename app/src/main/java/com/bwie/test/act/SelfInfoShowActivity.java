package com.bwie.test.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.test.R;
import com.bwie.test.bean.AllInfoBean;

import java.io.Serializable;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/28 08:31
 */

public class SelfInfoShowActivity extends BaseActivity {

    private ImageView image;
    private TextView name;
    private TextView info;
    private TextView nowPrice;
    private TextView oldPrice;
    private AllInfoBean allInfoBean;
    private int position=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selfinfoshow);
        initView();
         position=getIntent().getIntExtra("position",0);
        allInfoBean = (AllInfoBean)getIntent().getSerializableExtra("bean");
        int itemViewType=getIntent().getIntExtra("itemViewType",0);
        switch (itemViewType){
            case 0:
                Glide.with(this)
                        .load(allInfoBean.getData().getBestSellers().get(position).getGoodsList().get(position).getGoods_img())
                        .into(image);
                name.setText(allInfoBean.getData().getBestSellers().get(position).getGoodsList().get(position).getEfficacy());
                info.setText(allInfoBean.getData().getBestSellers().get(position).getGoodsList().get(position).getGoods_name());
                nowPrice.setText("￥"+allInfoBean.getData().getBestSellers().get(position).getGoodsList().get(position).getShop_price());
                oldPrice.setText("￥"+allInfoBean.getData().getBestSellers().get(position).getGoodsList().get(position).getMarket_price());
                break;
            case 1:
                Glide.with(this)
                        .load(allInfoBean.getData().getSubjects().get(position).getGoodsList().get(position).getGoods_img())
                        .into(image);
                name.setText(allInfoBean.getData().getSubjects().get(position).getGoodsList().get(position).getEfficacy());
                info.setText(allInfoBean.getData().getSubjects().get(position).getGoodsList().get(position).getGoods_name());
                nowPrice.setText("￥"+allInfoBean.getData().getSubjects().get(position).getGoodsList().get(position).getShop_price());
                oldPrice.setText("￥"+allInfoBean.getData().getSubjects().get(position).getGoodsList().get(position).getMarket_price());
                break;
            case 2:
                Glide.with(this)
                        .load(allInfoBean.getData().getDefaultGoodsList().get(position).getGoods_img())
                        .into(image);
                name.setText(allInfoBean.getData().getDefaultGoodsList().get(position).getEfficacy());
                info.setText(allInfoBean.getData().getDefaultGoodsList().get(position).getGoods_name());
                nowPrice.setText("￥"+allInfoBean.getData().getDefaultGoodsList().get(position).getShop_price());
                oldPrice.setText("￥"+allInfoBean.getData().getDefaultGoodsList().get(position).getMarket_price());
                break;
        }
    }

    private void initView() {
        image = (ImageView) findViewById(R.id.info_iv);
        name = (TextView) findViewById(R.id.text_info);
        info = (TextView) findViewById(R.id.info_tv);
        nowPrice = (TextView) findViewById(R.id.nowPrice);
        oldPrice = (TextView) findViewById(R.id.oldPrice);
    }
    //返回键
    public void back(View view) {
        finish();
    }
    //login键
    public void login(View view) {
    }
}
