package com.volvo.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.volvo.weather.http.bean.AllForecasts
import java.util.*


class RvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    private var allForecasts: MutableList<AllForecasts>? = null
    fun combine(cityAllForecasts: AllForecasts) {
        if (allForecasts == null) {
            allForecasts = ArrayList()
        }
        allForecasts!!.add(cityAllForecasts)
        notifyDataSetChanged()
    }

    fun setData(cityAllForecasts: MutableList<AllForecasts>){
        allForecasts = cityAllForecasts
        notifyDataSetChanged()
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.city_weather_item, parent, false)
        return CityWeatherViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CityWeatherViewHolder) {
            holder.updateView(allForecasts!![position].allForecastBeanList!![0])
        }
    }

    override fun getItemCount(): Int {
        return if (allForecasts != null) allForecasts!!.size else 0
    }
}