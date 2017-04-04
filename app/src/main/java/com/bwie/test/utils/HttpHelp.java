package com.bwie.test.utils;

import android.util.Log;

import com.bwie.test.bean.AllInfoBean;
import com.bwie.test.fragment.HomePage;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/19 19:06
 */

public class HttpHelp {
    public static <T> void getHttp(String url, final Class<T> clazz, final CallBackToData callBackToData){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String json=response.body().string();
                Gson gson=new Gson();
                T homeData=gson.fromJson(json,clazz);
                callBackToData.backData(homeData);
            }
        });
    }
    public interface CallBackToData<T>{
        void backData(T data);
    }
   
}
