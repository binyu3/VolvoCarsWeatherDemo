package com.volvo.weather

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.volvo.weather.databinding.CityWeatherItemBinding
import com.volvo.weather.http.bean.Forecast

class CityWeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = CityWeatherItemBinding.bind(itemView)

    fun updateView(forecast: Forecast?) {
        forecast?.let {
            binding.data = it
        }
    }
}