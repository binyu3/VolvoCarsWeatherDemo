package com.volvo.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.volvo.weather.http.bean.AllForecasts
import com.volvo.weather.http.bean.CityBean
import com.volvo.weather.repository.RepositoryUtils

class WeatherViewModel : ViewModel() {

    private val hotCities = arrayOf(
        CityBean("北京市", "110000"),
        CityBean("上海市", "310000"),
        CityBean("广州市", "440100"),
        CityBean("深圳市", "440300"),
        CityBean("苏州市", "320500"),
        CityBean("沈阳市", "210100")
    )

    val allForecasts: MutableLiveData<MutableList<AllForecasts>> by lazy {
        MutableLiveData<MutableList<AllForecasts>>().also {
            queryCityWeather()
        }
    }

    private fun queryCityWeather(){

        for (city in hotCities) {
            RepositoryUtils.queryCityWeather(city) {
                it?.let {
                    if (allForecasts.value == null) {
                        allForecasts.value = arrayListOf()
                    }
                    allForecasts.value?.add(it)
                }
            }
        }

    }
}