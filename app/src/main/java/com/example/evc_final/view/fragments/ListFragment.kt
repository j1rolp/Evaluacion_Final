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
import com.example.evc_final.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVEc_finalListAdapter(listOf()){ ec_final ->
            val deatilDirection = ListFragmentDirections.actionListFragmentToDetailFragment(ec_final)
            findNavController().navigate(deatilDirection)
        }
        binding.rvList.adapter = adapter
        binding.rvList.layoutManager = GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
        viewModel.Ec_finalList.observe(requireActivity()) {
            adapter.results = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getEc_FinalFromService()
    }
}