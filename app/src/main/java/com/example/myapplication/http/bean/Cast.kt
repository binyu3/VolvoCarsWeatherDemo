package com.example.myapplication.http.bean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Cast {
    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("week")
    @Expose
    var week: String? = null

    @SerializedName("dayweather")
    @Expose
    var dayweather: String? = null

    @SerializedName("nightweather")
    @Expose
    var nightweather: String? = null

    @SerializedName("daytemp")
    @Expose
    var daytemp: String? = null

    @SerializedName("nighttemp")
    @Expose
    var nighttemp: String? = null

    @SerializedName("daywind")
    @Expose
    var daywind: String? = null

    @SerializedName("nightwind")
    @Expose
    var nightwind: String? = null

    @SerializedName("daypower")
    @Expose
    var daypower: String? = null

    @SerializedName("nightpower")
    @Expose
    var nightpower: String? = null
}