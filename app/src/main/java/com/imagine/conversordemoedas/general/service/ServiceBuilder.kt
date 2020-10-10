package com.imagine.conversordemoedas.general.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    //BASE URL
    private const val URL = "https://economia.awesomeapi.com.br/"




    // BUILDER RETROFIT
    private val builder = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        

    // CREATE RETROFIT INSTANCE
    private val retrofit = builder.build()

    fun <T> builderService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}