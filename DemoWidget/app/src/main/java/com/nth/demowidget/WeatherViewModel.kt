package com.nth.demowidget

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Nguyen Tien Hoa on 09/13/2020
 */
 
 

class WeatherViewModel {

    private val repository: WeatherRepository = Retrofit.Builder()
        .baseUrl("https://songserver.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(
            RxJava2CallAdapterFactory.create()
        ).build()
        .create(WeatherRepository::class.java)

    val weatherObj = MutableLiveData<WeatherObj>()

    fun getWeather(local:String,context: Context):Disposable{
        return repository.getWeather(local,"92ada847e998e65db48e9cb5eadf0829","metric")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                weatherObj.value = it
                Utils.saveWeather(it,context)
//                Log.i("Test",it.name+","+it.varweather.description)
            },{
                it.printStackTrace()
            })


    }


}