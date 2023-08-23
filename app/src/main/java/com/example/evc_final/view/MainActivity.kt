package com.example.evc_final.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.evc_final.R
import com.example.evc_final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHeadFragment=supportFragmentManager.findFragmentById(R.id.fcv_evc_final) as NavHostFragment
        val navController=navHeadFragment.navController
        binding.bnvMenu.setupWithNavController(navController)
    }
}