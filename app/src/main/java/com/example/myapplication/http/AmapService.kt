package com.example.myapplication.http

import com.example.myapplication.http.bean.AllForecasts
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AmapService {
    @FormUrlEncoded
    @POST(AmapContants.AMAP_WEATHER_PATH)
    fun allweatherPost(
            @Field("city") city: String?,
            @Field("key") key: String?,
            @Field("extensions") extensions: String?,
            @Field("output") output: String?
    ): Observable<AllForecasts?>
}