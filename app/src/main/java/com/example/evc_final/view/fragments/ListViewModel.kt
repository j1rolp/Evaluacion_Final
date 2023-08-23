package com.example.evc_final.view.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evc_final.data.repository.Ec_finalRepository
import com.example.evc_final.data.response.ApiResponse
import com.example.evc_final.model.Ec_final
import com.example.evc_final.model.getData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel:ViewModel() {
    val repository= Ec_finalRepository()
    val Ec_finalList:MutableLiveData<List<Ec_final>> =MutableLiveData<List<Ec_final>>()

    fun getEc_finalList(){
        val data= getData()
        Ec_finalList.value =data
    }
    fun getEc_FinalFromService(){
        viewModelScope.launch(Dispatchers.IO){
            val response=repository.getEc_final()
            when(response){
                is ApiResponse.Error -> {
                    val errorMessage = response.exception?: "Unknown error"
                    Log.e("NetworkError", "Error getting Ec_final: $errorMessage")
                }
                is ApiResponse.Success -> {
                    Ec_finalList.postValue(response.data.results)
                }
            }
        }
    }
}