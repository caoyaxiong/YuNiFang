package com.bwie.test.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bwie.test.R;
import com.bwie.test.adapter.TypeAdapter;
import com.bwie.test.bean.GongXiao;
import com.bwie.test.common.Constants;
import com.bwie.test.utils.HttpHelp;


/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/16 15:31
 */

public class SortPage extends Fragment implements HttpHelp.CallBackToData, SwipeRefreshLayout.OnRefreshListener {
    private View view;
    private RecyclerView recyclerView;
    private TypeAdapter adapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            GongXiao gongXiao= (GongXiao) msg.obj;
            adapter = new TypeAdapter(getContext(),gongXiao);
            recyclerView.setAdapter(adapter);
        }
    };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.six_type_home, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HttpHelp.getHttp(Constants.GOODSSHOW,GongXiao.class,this);
        initView(view);


    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.grid_recy);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false));

    }


    @Override
    public void backData(Object data) {
        Message message=Message.obtain(handler,0,data);
        handler.sendMessage(message);
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                HttpHelp.getHttp(Constants.GOODSSHOW,GongXiao.class,SortPage.this);
                adapter.notifyDataSetChanged();
            }
        },3000);
    }


}

