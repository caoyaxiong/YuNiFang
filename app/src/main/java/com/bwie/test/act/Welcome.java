package com.bwie.test.act;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bwie.test.R;
import com.bwie.test.utils.ContextUtil;


public class Welcome extends BaseActivity {
    private ImageView imageView;
    private boolean flag;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {

                preferences = getSharedPreferences("YuNiFang", MODE_PRIVATE);
                editor = preferences.edit();
                flag = preferences.getBoolean("flag", false);
                if (flag == true) {
                    Intent intent = new Intent(Welcome.this, MainActivity.class);
                    startActivity(intent);
                    ContextUtil.exit();
                    finish();
                } else {
                    Intent intent = new Intent(Welcome.this, StartPage.class);
                    flag = true;
                    editor.putBoolean("flag", flag).commit();
                    startActivity(intent);
                    ContextUtil.exit();
                    finish();
                }
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        imageView = (ImageView) findViewById(R.id.welcome_image);
        new Thread(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.mipmap.loading_icon);
                handler.sendEmptyMessageDelayed(1, 2000);
            }
        }).start();
    }
}
