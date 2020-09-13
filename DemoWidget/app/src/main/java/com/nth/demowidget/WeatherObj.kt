package com.nth.demowidget

import com.nth.demowidget.model.*

/**
 * Created by Nguyen Tien Hoa on 09/13/2020
 */


data class WeatherObj(
    var coord: Coord,
    var varweather: Weather,
    var base: String,
    var main: Main,
    var visibility: Long,
    var wind: Wind,
    var clouds: Clouds,
    var dt: Long,
    var sys: Sys,
    var timezone: Long,
    var id: Long,
    var name: String,
    var cod: Int
) {

//    "coord": {
//        "lon": 105.84,
//        "lat": 21.02
//    },
//    "weather": [
//    {
//        "id": 802,
//        "main": "Clouds",
//        "description": "scattered clouds",
//        "icon": "03n"
//    }
//    ],
//    "base": "stations",
//    "main": {
//        "temp": 28,
//        "feels_like": 32.5,
//        "temp_min": 28,
//        "temp_max": 28,
//        "pressure": 1011,
//        "humidity": 83
//    },
//    "visibility": 10000,
//    "wind": {
//        "speed": 2.6,
//        "deg": 110
//    },
//    "clouds": {
//        "all": 40
//    },
//    "dt": 1600013706,
//    "sys": {
//        "type": 1,
//        "id": 9308,
//        "country": "VN",
//        "sunrise": 1599950603,
//        "sunset": 1599994921
//    },
//    "timezone": 25200,
//    "id": 1581130,
//    "name": "Hanoi",
//    "cod": 200

}