package com.example.apideadpool

import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroApi {
    @GET("{id}")
    suspend fun getSuperhero(@Path("id") id: String): Superhero
}