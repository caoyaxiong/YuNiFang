package com.bwie.test;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import org.xutils.x;
/**
 * Created by jinguo on 2017/3/16.
 */

public class CrashApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //全局的异常捕获
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
       
        x.Ext.init(this);
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(this);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
       
    }
}
