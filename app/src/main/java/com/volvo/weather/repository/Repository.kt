package com.volvo.weather.repository

import com.volvo.weather.http.AmapHttpClient
import com.volvo.weather.http.IAmapHttpClient

object Repository {
    fun http(): IAmapHttpClient? {
        if (Ext.mIAmapHttpClient == null) {
            AmapHttpClient.Companion.registerInstance()
        }
        return Ext.mIAmapHttpClient
    }

    object Ext {
        var mIAmapHttpClient: IAmapHttpClient? = null
        fun setAmapHttpManager(httpManager: IAmapHttpClient?) {
            mIAmapHttpClient = httpManager
        }
    }
}