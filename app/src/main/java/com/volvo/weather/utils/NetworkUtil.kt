package com.volvo.weather.utils

import android.content.Context
import android.net.ConnectivityManager
import com.volvo.weather.WeatherApplication


object NetworkUtil {
    val isNetworkConnected: Boolean
        get() {
            val context: Context? = WeatherApplication.context
            if (context != null) {
                val mConnectivityManager = context
                        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val mNetworkInfo = mConnectivityManager.activeNetworkInfo
                if (mNetworkInfo != null) {
                    return mNetworkInfo.isAvailable
                }
            }
            return false
        }
}