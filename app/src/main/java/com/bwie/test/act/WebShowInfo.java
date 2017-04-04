package com.bwie.test.act;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwie.test.R;


/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/18 12:17
 */

public class WebShowInfo extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_show_item);
        init();

    }

    private void init() {
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        String url=getIntent().getStringExtra("url");
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub  
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器  
                view.loadUrl(url);//用对应webView加载对应url内容进行显示  
                return true;
            }
        });
    }


}