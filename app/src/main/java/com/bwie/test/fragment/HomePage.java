package com.bwie.test.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bwie.test.R;
import com.bwie.test.adapter.HomePageAdapter;
import com.bwie.test.bean.AllInfoBean;
import com.bwie.test.common.Constants;
import com.bwie.test.utils.GlideImageLoader;
import com.bwie.test.utils.HttpHelp;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;


/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/16 15:30
 */

public class HomePage extends Fragment implements HttpHelp.CallBackToData, SwipeRefreshLayout.OnRefreshListener {

    private View view;
    private List<AllInfoBean> list=new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private HomePageAdapter homePageAdapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            AllInfoBean allInfoBean= (AllInfoBean) msg.obj;
            homePageAdapter = new HomePageAdapter(getContext(),allInfoBean);
            recyclerView.setAdapter(homePageAdapter);
        }
    };
    
   

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(),R.layout.homepage, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HttpHelp.getHttp(Constants.ADVURI,AllInfoBean.class,this);
        initView(view);
       
        
    }
   
    private void initView(View view) {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,Color.RED,Color.BLUE);
        swipeRefreshLayout.setOnRefreshListener(this);
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
                HttpHelp.getHttp(Constants.ADVURI,AllInfoBean.class,HomePage.this);  
                homePageAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        },3000);
    }

    
}
