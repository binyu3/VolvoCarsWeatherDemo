package com.volvo.weather

import android.app.Application
import android.content.Context

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        var context: Context? = null
    }
}