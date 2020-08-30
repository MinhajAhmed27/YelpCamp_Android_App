package com.example.yelpcamp.services

import com.example.yelpcamp.models.model
import retrofit2.Call
import retrofit2.http.GET

interface WebServices {

    @GET("campground")
    fun getCampgroungList(): Call<List<model>>

}