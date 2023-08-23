package com.example.evc_final

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evc_final.R
import com.example.evc_final.databinding.ItemListBinding
import com.example.evc_final.model.Ec_final

class RVEc_finalListAdapter(var results: List<Ec_final>, val onClick: (Ec_final) -> Unit): RecyclerView.Adapter<Ec_finalVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Ec_finalVH {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Ec_finalVH(binding, onClick)
    }

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: Ec_finalVH, position: Int) {
        holder.bind(results.run { get(position) })
    }
}

class Ec_finalVH(private val binding: ItemListBinding, val onClick: (Ec_final) -> Unit): RecyclerView.ViewHolder(binding.root) {
    fun bind(results: Ec_final) {
        Glide.with(binding.root.context)
            .load(results.img)
            .placeholder(R.drawable.ic_personaje)
            .error(R.drawable.ic_personaje)
            .into(binding.imagenView)
        binding.nameTitan.text = results.name
        binding.altura.text = results.height
        binding.root.setOnClickListener {
            onClick(results)
        }
    }
}