package com.volvo.weather.repository

import com.volvo.weather.http.bean.AllForecasts
import com.volvo.weather.http.bean.CityBean
import com.volvo.weather.repository.Repository.http
import com.volvo.weather.utils.NetworkUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


object RepositoryUtils {
    fun queryCityWeather(cityBean: CityBean,
                         queryCallback: (AllForecasts?) -> Unit) {
        if (!NetworkUtil.isNetworkConnected) {
            return
        }

        http()!!.forecastWeatherPost(cityBean.cityCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { allForecasts ->
                    queryCallback.invoke(allForecasts)
                }
    }
}