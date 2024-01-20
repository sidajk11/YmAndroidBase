package com.example.ymsamplexml

import com.example.ymsamplexml.data.HeroesDM
import com.example.ymsamplexml.data.HeroDM
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

class OpenApi {
    companion object {
        const val DOMAIN = "http://10.0.2.2:8000"
        const val API_KEY = ""
    }
}

interface Service {
    @GET("/heroes")
    fun getHeroes() : Call<HeroesDM>

    @GET("/heroes/{hero_id}")
    fun getHero(@Path("hero_id") id: String) : Call<HeroDM>
}