package com.example.evc_final.view.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evc_final.data.db.Ec_finalDataBase
import com.example.evc_final.data.repository.Ec_finalRepository
import com.example.evc_final.model.Ec_final
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Ec_finalRepository
    private val _favorite: MutableLiveData<List<Ec_final>> = MutableLiveData()
    val favorites: LiveData<List<Ec_final>> = _favorite
    init {
        val db = Ec_finalDataBase.getDatabase(application)
        repository = Ec_finalRepository(db.Ec_finalDao())
        getFavorites()
    }
    fun getFavorites(){
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getFavorites()
            withContext(Dispatchers.Main){
                _favorite.value = data
            }
        }
    }
}