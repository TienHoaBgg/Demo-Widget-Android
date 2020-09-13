package com.nth.demowidget

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import com.nth.demowidget.model.WeatherView

object Utils {
    @JvmStatic
    fun saveWeather(weather: WeatherObj,context: Context) {
        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putString("CITY", weather.name)
        editor.putString("COUNTRY", weather.sys.country)
//        editor.putString("STATUS", weather.varweather.description)
        editor.putFloat("TEMP", weather.main.temp)
        editor.putFloat("TEMP_MAX", weather.main.temp_max)
        editor.putFloat("TEMP_MIN", weather.main.temp_min)
        editor.apply()
    }
    @JvmStatic
    fun readWeather(context: Context): WeatherView {
        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)
        val city = sharedPreferences.getString("CITY", "HaNoi")
        val country = sharedPreferences.getString("COUNTRY", "VN")
//        val status = sharedPreferences.getString("STATUS", "ABC")
        val temp = sharedPreferences.getFloat("TEMP", 0f)
        val tempMax = sharedPreferences.getFloat("TEMP_MAX", 0f)
        val tempMin = sharedPreferences.getFloat("TEMP_MIN", 0f)
        return WeatherView(city, country,"", temp, tempMax, tempMin)
    }


}