package com.example.myapplication.repository

import com.example.myapplication.http.AmapHttpClient
import com.example.myapplication.http.IAmapHttpClient

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