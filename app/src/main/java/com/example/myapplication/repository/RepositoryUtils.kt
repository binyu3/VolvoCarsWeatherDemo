package com.example.myapplication.repository

import com.example.myapplication.http.bean.AllForecasts
import com.example.myapplication.http.bean.CityBean
import com.example.myapplication.repository.Repository.http
import com.example.myapplication.utils.NetworkUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


object RepositoryUtils {
    fun queryCityWeather(citybean: CityBean,
                         queryCallback: IQueryWeatherCallback) {
        if (!NetworkUtil.isNetworkConnected) {
            return
        }

        val observable: Observable<AllForecasts?> = http()!!.forecastWeatherPost(citybean.cityCode).subscribeOn(Schedulers.io())



        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Consumer<AllForecasts?> {
                    //@kotlin.Throws(Exception::class)
                    override fun accept(allForecasts: AllForecasts?) {
                        queryCallback.onWeatherQueryCompleted(allForecasts!!)
                    }
                })
    }

    interface IQueryWeatherCallback {
        fun onWeatherQueryCompleted(allForecasts: AllForecasts)
    }
}