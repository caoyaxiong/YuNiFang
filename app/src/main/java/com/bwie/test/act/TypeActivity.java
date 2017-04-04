package com.bwie.test.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.test.R;
import com.bwie.test.bean.AllInfoBean;
import com.bwie.test.bean.GongXiao;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/28 08:31
 */

public class TypeActivity extends BaseActivity {

    private ImageView image;
    private TextView name;
    private TextView info;
    private TextView nowPrice;
    private TextView oldPrice;
    private GongXiao gongXiao;
    private int position=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selfinfoshow);
        initView();
         position=getIntent().getIntExtra("position",0);
        gongXiao = (GongXiao) getIntent().getSerializableExtra("bean");
                Glide.with(this)
                        .load(gongXiao.getData().get(position).getGoods_img())
                        .into(image);
                name.setText(gongXiao.getData().get(position).getEfficacy());
                info.setText(gongXiao.getData().get(position).getGoods_name());
                nowPrice.setText("￥"+gongXiao.getData().get(position).getShop_price());
                oldPrice.setText("￥"+gongXiao.getData().get(position).getMarket_price());
               
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
