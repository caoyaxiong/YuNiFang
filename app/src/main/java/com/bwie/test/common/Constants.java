package com.bwie.test.common;

/**
 * Created by admin on 15/12/30.
 */

import android.os.Environment;

/**
 * 常量类
 *
 * @author KingKong-HE
 * @Time 2014-12-31
 * @Email KingKong@QQ.COM
 */
public final class Constants {


    private Constants() {
    }
    /**
     * banner   adv1轮播图地址
     */
    public static final String ADVURI="http://m.yunifang.com/yunifang/mobile/home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447";
    public static final String GOODSSHOW = "http://m.yunifang.com/yunifang/mobile/goods/getall?random=13819&encode=d58e53c4b9e24bd5ba276ba68f8e98ec&category_id=17";

    /**
     * 与服务器端连接的协议名
     */
    public static final String PROTOCOL = "http://";

    /**
     * 服务器域名
     */
//    public static final String HOST = "b2b.huatuoyf.com";//101.201.197.50www.htyyao.com  b2b.huatuoyf.com 测试地址    原来的地址

    public static final String HOST = "b2b.htyyao.com";//101.201.197.50  b2b.huatuoyf.com 测试地址    test1.htyyao.com原来的地址

    /**
     * IM服务器地址、端口号
     */
    public static final String IM_HOST = PROTOCOL + "121.43.11test0.146:8095";//www.shopnctest.com:8095 原来的地址

    /**
     * 服务器端口号
     */
    public static final String PORT = "80";

    /**
     * 应用上下文名
     */
    public static final String APP = "/mobile";///mobile



    //调试控制台日志
    public static final boolean DEBUG = true;
    //是否打印log
    public static final boolean LOG_ENABLE = DEBUG ? true : false;
    //是否弹出测试toast
    public static final boolean TOAST_ENABLE = DEBUG ? true : false;
    //是否将LOG写到sd上
    public static final boolean LOG2SD_ENABLE = false;

    // Log文件目录名称
    public static final String LOG_PATH_NAME = "YNFCrashLog";

}

