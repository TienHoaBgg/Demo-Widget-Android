package com.nth.demowidget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.util.Log
import android.widget.RemoteViews
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Implementation of App Widget functionality.
 */

class WidgetWeather : AppWidgetProvider() {
    private lateinit var model: WeatherViewModel
    private var mDispose: Disposable? = null

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }

        val weather = Utils.readWeather(context)


    }

    override fun onEnabled(context: Context) {

    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }


    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        model = WeatherViewModel()
        model.getWeather("Hanoi",context)
        val views = RemoteViews(context.packageName, R.layout.widget_weather)
        val weather = Utils.readWeather(context)

        views.setTextViewText(R.id.txt_location,weather.city+","+weather.country)
        views.setTextViewText(R.id.txt_nhietDo,"${weather.temp} C ")
        views.setTextViewText(R.id.txt_status,"${weather.status}")

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }


}