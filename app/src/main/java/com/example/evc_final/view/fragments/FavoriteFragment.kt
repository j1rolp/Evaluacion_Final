package com.example.evc_final.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evc_final.R
import com.example.evc_final.RVEc_finalListAdapter
import com.example.evc_final.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var viewModel: FavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(requireActivity()).get(FavoriteViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVEc_finalListAdapter(listOf()){ ec_final ->
            val deatilDirection = FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment(ec_final)
            findNavController().navigate(deatilDirection)
        }
        binding.rvFavorite.adapter = adapter
        binding.rvFavorite.layoutManager = GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
        viewModel.favorites.observe(requireActivity()) {
            adapter.results = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getFavorites()
    }
}