package com.bwie.test.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwie.test.R;
import com.bwie.test.act.MainActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 1、MODE_NIGHT_NO： 使用亮色(light)主题，不使用夜间模式；
 * 2、MODE_NIGHT_YES：使用暗色(dark)主题，使用夜间模式；
 * 3、MODE_NIGHT_AUTO：根据当前时间自动切换 亮色(light)/暗色(dark)主题；
 * 4、MODE_NIGHT_FOLLOW_SYSTEM(默认选项)：设置为跟随系统，通常为 MODE_NIGHT_NO
 */

public class PersonalPage extends Fragment {
    private static final String APP_ID = "1106015696";

    private IUiListener loginListener; //授权登录监听器
    private Tencent mTencent; //qq主操作对象  
    private DisplayImageOptions options;
    private View view;
    private MainActivity parentActivity;
    private ImageView qq_image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.login_state, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        parentActivity = (MainActivity) getActivity();
        LinearLayout imageView = (LinearLayout) view.findViewById(R.id.night);
        qq_image = (ImageView) view.findViewById(R.id.qq_login);
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new RoundedBitmapDisplayer(80))//不推荐用！！！！是否设置为圆角，弧度为多少  
                //.displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                .build();

        // Tencent类是SDK的主要实现类，开发者可通过Tencent类访问腾讯开放的OpenAPI。
// 其中APP_ID是分配给第三方应用的appid，类型为String。
        qq_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        
    }
    @Override
    public void onDestroy() {
        if (mTencent != null) {
            //注销登录  
            mTencent.logout(getActivity());
        }
        super.onDestroy();
    }
    private void login() {
        mTencent =  Tencent.createInstance("1106015696", getActivity());
        mTencent.login(this, "all", loginListener);
        loginListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                //登录成功后回调该方法,可以跳转相关的页面
                JSONObject object = (JSONObject) o;
                try {
                    String accessToken = object.getString("access_token");
                    String expires = object.getString("expires_in");
                    String openID = object.getString("openid");
                    mTencent.setAccessToken(accessToken, expires);
                    mTencent.setOpenId(openID);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(UiError uiError) {
            }
            @Override
            public void onCancel() {
            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == Constants.REQUEST_LOGIN) {
            if (resultCode == -1) {
                Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
                Tencent.handleResultData(data, loginListener);
                UserInfo info = new UserInfo(getActivity(), mTencent.getQQToken());
                info.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object o) {
                        try {
                            JSONObject info = (JSONObject) o;
                            String nickName = info.getString("nickname");//获取用户昵称
                            String iconUrl = info.getString("figureurl_qq_2");//获取用户头像的url
                            ImageLoader.getInstance().displayImage(iconUrl,qq_image,options);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(UiError uiError) {
                    }
                    @Override
                    public void onCancel() {
                    }
                });

            }

        }

    }


}
