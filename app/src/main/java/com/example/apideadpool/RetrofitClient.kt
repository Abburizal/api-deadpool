package com.example.apideadpool

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://superheroapi.com/api/442fbf21ad6cacfe8d4f8bdade8503f7/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val superheroApi: SuperheroApi by lazy {
        retrofit.create(SuperheroApi::class.java)
    }
}