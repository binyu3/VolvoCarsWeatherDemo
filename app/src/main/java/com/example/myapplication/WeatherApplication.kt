package com.example.myapplication

import android.app.Application
import android.content.Context

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setContext(applicationContext)
    }

    companion object {
        var context: Context? = null
            private set

        private fun setContext(context: Context) {
            this.context = context
        }

    }
}