package com.example.evc_final.data.repository

import com.example.evc_final.data.db.Ec_finalDao
import com.example.evc_final.data.retrofit.ServiceInstance
import com.example.evc_final.data.response.ListResponse
import com.example.evc_final.data.response.ApiResponse
import com.example.evc_final.model.Ec_final


class Ec_finalRepository(val ec_finalDao: Ec_finalDao? = null) {

    suspend fun getEc_final(): ApiResponse<ListResponse> {
        return try{
            val response= ServiceInstance.getEc_finalService().getEc_final()
            ApiResponse.Success(response)
        }catch(e: Exception){
            ApiResponse.Error(e)
        }
    }

    suspend fun addFavorite(ec_final: Ec_final){
        ec_finalDao?.let {
            it.addFavorite(ec_final)
        }
    }

    suspend fun borrarFavorite(ec_final: Ec_final){
        ec_finalDao?.let {
            it.borrarFavorite(ec_final)
        }
    }

    fun getFavorites(): List<Ec_final>{
        ec_finalDao?.let {
            return it.getFavorites()
        } ?: kotlin.run {
            return listOf()
        }
    }

}