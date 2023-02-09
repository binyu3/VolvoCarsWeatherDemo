package com.volvo.weather.http

import com.volvo.weather.http.bean.AllForecasts
import io.reactivex.Observable

interface IAmapHttpClient {
    fun forecastWeatherPost(adcode: String?): Observable<AllForecasts?>
}