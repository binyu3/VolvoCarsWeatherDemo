package com.volvo.weather.http.bean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Forecast {
    @SerializedName("city")
    @Expose
    var city: String? = null

    @SerializedName("adcode")
    @Expose
    var adcode: String? = null

    @SerializedName("province")
    @Expose
    var province: String? = null

    @SerializedName("reporttime")
    @Expose
    var reporttime: String? = null

    @SerializedName("casts")
    @Expose
    var casts: List<Cast?>? = null
}