package com.bwie.test.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;


public class DeviceManager {
	private static final String TAG = DeviceManager.class.getSimpleName();

	/**
	 * 获取当前网络连接状态
	 * 
	 * @param context
	 * @return
	 */
	@SuppressLint("InlinedApi")
	public static boolean isNetworkConnected(Context context) {

		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkinfo = manager.getActiveNetworkInfo();
		if (networkinfo != null && networkinfo.isConnected()) {
			String name = networkinfo.getTypeName();
			return true;
		}

		return false;
		
	}
	

	/**
	 * 获取设备唯一标示
	 * 
	 * @param context
	 * @return
	 */
	public static String getDeviceID(Context context) {

		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String deviceId = telephonyManager.getDeviceId();
		if (deviceId == null) {
			deviceId = getLocalMacAddress(context);
		}
		return deviceId;
	}

	/**
	 * 获取本机mac地址
	 *
	 * @param context
	 * @return
	 */
	public static String getLocalMacAddress(Context context) {
		WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = wifi.getConnectionInfo();
		return info.getMacAddress();
	}

}
