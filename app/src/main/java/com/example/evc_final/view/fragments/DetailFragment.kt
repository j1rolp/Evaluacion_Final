package com.example.evc_final.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.evc_final.R
import com.example.evc_final.databinding.FragmentDetailBinding
import com.example.evc_final.model.Ec_final


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    val args: DetailFragmentArgs by navArgs()
    private lateinit var results: Ec_final
    private lateinit var viewModel: DeatilViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        results = args.ecFinal
        viewModel = ViewModelProvider(requireActivity()).get(DeatilViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(binding.root.context)
            .load(results.img)
            .placeholder(R.drawable.ic_personaje)
            .error(R.drawable.ic_personaje)
            .into(binding.imgTitan)
        binding.nameTitan.text = results.name
        binding.altura.text = results.height
        binding.lugarPertenece.text = results.allegiance
        binding.btnAddFavorite.apply {
            visibility = if (results.isFavorite) View.GONE else View.VISIBLE
        }
        binding.btnBorrarFavorite.apply {
            visibility = if (results.isFavorite) View.VISIBLE else View.GONE
        }
        binding.btnAddFavorite.setOnClickListener {
            results.isFavorite = true
            viewModel.addFavorite(results)
        }
        binding.btnBorrarFavorite.setOnClickListener {
            results.isFavorite = true
            viewModel.borrarFavorite(results)
        }
    }

}