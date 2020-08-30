package com.example.yelpcamp.services

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBulider {
    private const val URL = "http://10.0.2.2:9000/"

    private val okHttp = OkHttpClient.Builder()

//    var gson = GsonBuilder()
//        .setLenient()
//        .create()

    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType:Class<T>):T{
        return retrofit.create(serviceType)
    }

}