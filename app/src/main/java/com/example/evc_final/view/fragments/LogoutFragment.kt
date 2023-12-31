package com.example.evc_final.view.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.evc_final.R
import com.example.evc_final.databinding.FragmentListBinding
import com.example.evc_final.databinding.FragmentLogoutBinding
import com.example.evc_final.view.LoginActivity
import com.example.evc_final.view.SplashScreenActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogoutFragment : Fragment() {

    private lateinit var binding: FragmentLogoutBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences(
            LoginActivity.SESSION_PREFERENCE,
            AppCompatActivity.MODE_PRIVATE
        )
        firebaseAuth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            sharedPreferences.edit().apply {
                putString(LoginActivity.EMAIL,"")
                    .apply()
            }
            val intent = Intent(requireActivity(), SplashScreenActivity::class.java)
            requireActivity().startActivity(intent)
            requireActivity().finish()
        }
    }
}