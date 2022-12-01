package com.example.clearcals.retrofit

import com.example.clearcals.model.FoodData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Api {

    @GET("recipes/list")
    suspend fun getData(@Query("from")page:Int,
                        @Query("size")size:Int,
                        @Query("q")word:String,
                        @Header("X-RapidAPI-Key")key:String, @Header("X-RapidAPI-Host")host:String
    ): FoodData
}