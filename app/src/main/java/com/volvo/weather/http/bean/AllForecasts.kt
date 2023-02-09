package com.volvo.weather.http.bean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AllForecasts {
    @SerializedName("status")
    @Expose
    private val status: String? = null

    @SerializedName("count")
    @Expose
    private val count: String? = null

    @SerializedName("info")
    @Expose
    private val info: String? = null

    @SerializedName("infocode")
    @Expose
    private val infocode: String? = null

    @SerializedName("forecasts")
    @Expose
    val allForecastBeanList: List<Forecast?>? = null
}