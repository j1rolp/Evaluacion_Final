package com.example.evc_final.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evc_final.databinding.ActivityAddTitanBinding
import com.example.evc_final.model.Ec_final
import com.example.evc_final.model.Ec_finalFirebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddTitanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTitanBinding
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTitanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firestore = Firebase.firestore

        binding.btnAgregarTitan.setOnClickListener {
            val name: String = binding.nameTitan.editText?.text.toString()
            val height: String = binding.heightTitan.editText?.text.toString()
            val allegiance: String = binding.allegianceTitan.editText?.text.toString()

            if (name.isNotEmpty() && height.isNotEmpty() && allegiance.isNotEmpty()){
                val Ec_final = hashMapOf(
                    "name" to name,
                    "height" to height,
                    "allegiance" to allegiance,
                    "img" to ""
                )
                firestore.collection("ec_final")
                    .add(Ec_final)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Se ha agregado Correctamente con id: ${it.id}", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "No se agregó el elemento", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
    private fun getData(){
        firestore.collection("ec_final").get()
            .addOnSuccessListener {
                val results = mutableListOf<Ec_finalFirebase>()
                for (document in it.documents){
                    val Ec_final : Ec_finalFirebase = Ec_finalFirebase(
                        name = document.data?.get("name").toString(),
                        height = document.data?.get("height").toString(),
                        allegiance = document.data?.get("allegiance").toString()
                    )
                    results.add(Ec_final)
                }
            }
    }
}