package com.example.myapplication.http

import com.example.myapplication.http.bean.AllForecasts
import io.reactivex.Observable

interface IAmapHttpClient {
    fun forecastWeatherPost(adcode: String?): Observable<AllForecasts?>
}