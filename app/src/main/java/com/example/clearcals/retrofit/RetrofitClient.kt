package com.example.clearcals.retrofit

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitClient {


    private val client = OkHttpClient.Builder().build()
    @Singleton
    @Provides
    fun getInstance(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl("https://tasty.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun init():Api
    {
        return getInstance().create(Api::class.java)
    }
}