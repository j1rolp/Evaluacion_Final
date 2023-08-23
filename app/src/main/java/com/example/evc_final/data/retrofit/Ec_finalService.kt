package com.example.evc_final.data.retrofit
import com.example.evc_final.data.response.ListResponse
import retrofit2.http.GET

interface Ec_finalService {
    @GET("/titans")
    suspend fun getEc_final() : ListResponse
}