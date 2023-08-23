package com.example.evc_final.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceInstance {
    private val retrofit=Retrofit.Builder()
        .baseUrl("https://api.attackontitanapi.com")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getEc_finalService(): Ec_finalService = retrofit.create(Ec_finalService::class.java)
}