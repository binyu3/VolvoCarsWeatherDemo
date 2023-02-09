package com.volvo.weather.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AmapRetrofitHelper private constructor() {
    private var mOkHttpClient: OkHttpClient? = null
    private var mRetrofit: Retrofit? = null
    private fun initRetrofit() {
        mRetrofit = Retrofit.Builder()
                .baseUrl(AmapContants.AMAP_HOST_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private fun initOkHttpClient() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        mOkHttpClient = OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIME.toLong(), TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIME.toLong(), TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME.toLong(), TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    fun <T> create(service: Class<T>?): T {
        return mRetrofit!!.create(service)
    }

    companion object {
        private const val DEFAULT_CONNECT_TIME = 20
        private const val DEFAULT_WRITE_TIME = 50
        private const val DEFAULT_READ_TIME = 30
        private var mAmapRetrofitHelper: AmapRetrofitHelper? = null

        @get:Synchronized
        val instance: AmapRetrofitHelper?
            get() {
                if (mAmapRetrofitHelper == null) {
                    mAmapRetrofitHelper = AmapRetrofitHelper()
                }
                return mAmapRetrofitHelper
            }
    }

    init {
        initOkHttpClient()
        initRetrofit()
    }
}