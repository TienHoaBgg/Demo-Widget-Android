package com.nth.demowidget

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {
    private lateinit var model: WeatherViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = WeatherViewModel()
        model.getWeather("Hanoi",baseContext)


    }

    companion object {
        private var instance: MainActivity? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

        fun getApplication(): Application {
            return instance!!.application
        }
    }
}