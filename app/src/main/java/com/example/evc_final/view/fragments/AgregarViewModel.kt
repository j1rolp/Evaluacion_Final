package com.example.evc_final.view.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.evc_final.model.Ec_final
import com.example.evc_final.model.Ec_finalFirebase
import com.google.firebase.firestore.FirebaseFirestore

class AgregarViewModel: ViewModel() {

    private val firestore= FirebaseFirestore.getInstance()
    val listaTitan: MutableLiveData<List<Ec_finalFirebase>> = MutableLiveData()

    fun cargarTitanes(){
        firestore.collection("ec_final").get()
            .addOnSuccessListener {
                val results = mutableListOf<Ec_finalFirebase>()
                for(document in it.documents){
                    val Ec_final = Ec_finalFirebase(
                        name = document.data?.get("name").toString(),
                        height = document.data?.get("height").toString(),
                        allegiance = document.data?.get("allegiance").toString()
                    )
                    results.add(Ec_final)
                }
                listaTitan.value = results
            }
    }
}