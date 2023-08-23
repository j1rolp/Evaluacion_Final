package com.example.evc_final.view.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.evc_final.data.db.Ec_finalDataBase
import com.example.evc_final.data.repository.Ec_finalRepository
import com.example.evc_final.model.Ec_final
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeatilViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Ec_finalRepository
    init {
        val db = Ec_finalDataBase.getDatabase(application)
        repository = Ec_finalRepository(db.Ec_finalDao())
    }
    fun addFavorite(ec_final:Ec_final){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFavorite(ec_final)
        }
    }
    fun borrarFavorite(ec_final:Ec_final){
        viewModelScope.launch(Dispatchers.IO) {
            repository.borrarFavorite(ec_final)
        }
    }
}