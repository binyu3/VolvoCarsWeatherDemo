package com.example.myapplication.http

import com.example.myapplication.http.bean.AllForecasts
import com.example.myapplication.repository.Repository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


class AmapHttpClient private constructor() : IAmapHttpClient {
    private fun createApiClient(): AmapService? {
        if (amapService == null) {
            amapService = AmapRetrofitHelper.instance?.create(AmapService::class.java)
        }
        return amapService
    }

    override fun forecastWeatherPost(adcode: String?): Observable<AllForecasts?> {
        return amapService!!.allweatherPost(adcode,
                AmapContants.AMAP_USER_KEY_VALUE,
                AmapContants.AMAP_EXTENSIONS_ALL,
                AmapContants.AMAP_OUTPUT_JSON)
                .subscribeOn(Schedulers.io())
    }

    companion object {
        private var amapHttpClient: AmapHttpClient? = null
        private var amapService: AmapService? = null
        //@kotlin.jvm.Synchronized
        fun registerInstance() {
            if (amapHttpClient == null) {
                amapHttpClient = AmapHttpClient()
            }
            Repository.Ext.setAmapHttpManager(amapHttpClient)
        }
    }

    init {
        createApiClient()
    }
}