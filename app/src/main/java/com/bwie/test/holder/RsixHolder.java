package com.bwie.test.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.test.R;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/23 19:50
 */

public class RsixHolder extends RecyclerView.ViewHolder {
    
    public final ImageView hot_iv;
    public final TextView hot_tv,now_price,old_price,text_hot;
    public final LinearLayout linearLayout;
    public RsixHolder(View itemView) {
        super(itemView);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.six_info_item);
        hot_iv = (ImageView) itemView.findViewById(R.id.hot_iv);
        hot_tv = (TextView) itemView.findViewById(R.id.hot_tv);
        text_hot = (TextView) itemView.findViewById(R.id.text_hot);
        now_price = (TextView) itemView.findViewById(R.id.nowPrice);
        old_price = (TextView) itemView.findViewById(R.id.oldPrice);
    }
}
