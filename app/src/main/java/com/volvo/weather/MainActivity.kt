package com.volvo.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.weather_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        val rvAdapter = RvAdapter()
        recyclerView.adapter = rvAdapter

        val viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        viewModel.allForecasts.observe(this, {
            rvAdapter.setData(it)
        })
    }
}