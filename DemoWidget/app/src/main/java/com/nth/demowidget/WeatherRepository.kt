package com.nth.demowidget

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Nguyen Tien Hoa on 09/13/2020
 */


interface WeatherRepository {
    @GET("http://api.openweathermap.org/data/2.5/weather")
    fun getWeather(
        @Query(value = "q") local:String,
        @Query(value = "appid") apiKey:String,
        @Query(value = "units") format:String
    ) : Observable<WeatherObj>
}