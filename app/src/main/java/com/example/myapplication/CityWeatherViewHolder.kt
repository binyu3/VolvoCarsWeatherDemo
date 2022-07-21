package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.http.bean.Forecast

class CityWeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cityName: TextView
    private val date: TextView
    private val dayWeather: TextView
    private val nightWeather: TextView
    fun updateView(forecast: Forecast?) {
        cityName.text = forecast!!.city
        val tomorrow = forecast.casts!![1]
        date.text = tomorrow!!.date
        dayWeather.text = "白天：" + tomorrow.dayweather
        nightWeather.text = "夜间：" + tomorrow.nightweather
    }

    init {
        cityName = itemView.findViewById(R.id.city_name)
        date = itemView.findViewById(R.id.date)
        dayWeather = itemView.findViewById(R.id.day_weather)
        nightWeather = itemView.findViewById(R.id.night_weather)
    }
}