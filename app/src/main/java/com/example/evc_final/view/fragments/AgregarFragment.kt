package com.example.evc_final.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evc_final.R
import com.example.evc_final.RVEc_finalAgregarAdapter
import com.example.evc_final.databinding.FragmentAgregarBinding
import com.example.evc_final.databinding.ItemListBinding
import com.example.evc_final.model.Ec_final
import com.example.evc_final.model.Ec_finalFirebase
import com.example.evc_final.view.AddTitanActivity

class AgregarFragment : Fragment() {

    private lateinit var binding: FragmentAgregarBinding
    private lateinit var adapter: RVEc_finalAgregarAdapter
    private lateinit var viewModel: AgregarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarBinding.inflate(inflater, container, false)
        binding.btnAgregar.setOnClickListener {
            val intent = Intent(requireContext(), AddTitanActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AgregarViewModel::class.java)
        adapter = RVEc_finalAgregarAdapter(emptyList()){
        }
        binding.rvFirebase.adapter = adapter
        binding.rvFirebase.layoutManager = GridLayoutManager(requireContext(),1,RecyclerView.VERTICAL,false)
        viewModel.listaTitan.observe(viewLifecycleOwner){
            adapter.results = it
            adapter.notifyDataSetChanged()
        }
        viewModel.cargarTitanes()
    }
}