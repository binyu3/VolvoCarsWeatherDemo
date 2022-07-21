package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.http.bean.AllForecasts
import com.example.myapplication.http.bean.CityBean
import com.example.myapplication.repository.RepositoryUtils.IQueryWeatherCallback
import com.example.myapplication.repository.RepositoryUtils.queryCityWeather


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.weather_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        val rvAdapter = RvAdapter()
        recyclerView.adapter = rvAdapter
        val cities = arrayOf(
                CityBean("北京市", "110000"),
                CityBean("上海市", "310000"),
                CityBean("广州市", "440100"),
                CityBean("深圳市", "440300"),
                CityBean("苏州市", "320500"),
                CityBean("沈阳市", "210100")
        )
        for (city in cities) {
            queryCityWeather(city, object : IQueryWeatherCallback {
                override fun onWeatherQueryCompleted(allForecasts: AllForecasts) {
                    rvAdapter.combine(allForecasts)
                }
            })
        }
    }
}