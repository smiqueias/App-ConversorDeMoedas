package com.imagine.conversordemoedas.general.service

import retrofit2.Call
import com.imagine.conversordemoedas.general.model.PriceDolarAndEuro
import retrofit2.http.GET

interface PriceDolarAndEuroService {

@GET("all/USD-BRL,EUR-BRL")
fun getPriceDolarAndEuro(): Call<PriceDolarAndEuro>
}