package com.example.evc_final

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evc_final.databinding.ItemFirebaseBinding
import com.example.evc_final.model.Ec_final
import com.example.evc_final.model.Ec_finalFirebase

class RVEc_finalAgregarAdapter(var results: List<Ec_finalFirebase>, val onClick: (Ec_finalFirebase) -> Unit): RecyclerView.Adapter<Ec_finalFirebaseVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Ec_finalFirebaseVH {
        val binding = ItemFirebaseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Ec_finalFirebaseVH(binding, onClick)
    }

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: Ec_finalFirebaseVH, position: Int) {
        holder.bind(results[position])
    }
}

class Ec_finalFirebaseVH(private val binding: ItemFirebaseBinding, val onClick: (Ec_finalFirebase) -> Unit): RecyclerView.ViewHolder(binding.root) {
    fun bind(results: Ec_finalFirebase) {
        binding.nameTitan.text = results.name
        binding.altura.text = results.height
        binding.allegiance.text = results.allegiance
        binding.root.setOnClickListener {
            onClick(results)
        }
    }
}