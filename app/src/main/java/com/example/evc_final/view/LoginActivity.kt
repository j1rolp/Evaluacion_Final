package com.example.evc_final.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.evc_final.R
import com.example.evc_final.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleLauncher: ActivityResultLauncher<Intent>
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences
    private var isEmailOk: Boolean=false
    private var isPasswordOk: Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding =ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        sharedPreferences = getSharedPreferences(SESSION_PREFERENCE, MODE_PRIVATE)
        firebaseAuth = Firebase.auth
        googleLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    signinFirebaseWithGoogle(account.idToken)
                }catch (e:Exception){

                }
            }
        }
    }

    private fun signinFirebaseWithGoogle(idToken: String?) {
        val authCredential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(authCredential)
            .addOnCompleteListener (this){
                if (it.isSuccessful){
                    val user: FirebaseUser = firebaseAuth.currentUser!!
                    sharedPreferences.edit().apply{
                        putString(EMAIL, user.email)
                            .apply()
                    }
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this, "Ocurrio un error", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun setupViews(){
        binding.email.editText?.addTextChangedListener { text ->
            binding.btnLogin.isEnabled=validateInput(text.toString(),binding.password.editText?.text.toString())
        }
        binding.password.editText?.addTextChangedListener { text ->
            binding.btnLogin.isEnabled=validateInput(binding.email.editText?.text.toString(),text.toString())
        }
        binding.btnLogin.setOnClickListener{
            signInWithEmailPassword()
        }

        binding.btnGoogle.setOnClickListener {
            signInWithGoogle()
        }
        binding.btnSignUp.setOnClickListener {
            signUpWithEmailPassword()
        }
    }

    private fun signUpWithEmailPassword() {
        val email = binding.email.editText?.text.toString()
        val password = binding.password.editText?.text.toString()
        if (validateInput(email, password)){
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Usuario creado correctamente.", Toast.LENGTH_SHORT).show()
                    } else{
                        Toast.makeText(this, "Usuario creado no pudo ser creado.", Toast.LENGTH_SHORT).show()
                    }
                }
        } else{
            Toast.makeText(this, "Credenciales no válidas", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signInWithEmailPassword() {
        val email = binding.email.editText?.text.toString()
        val password = binding.password.editText?.text.toString()
        signInFirebaseWithEmail(email, password)
    }

    private fun signInFirebaseWithEmail(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful){
                    val user = firebaseAuth.currentUser
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Usuario creado no se encontró.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun signInWithGoogle() {
        val googleSignOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("116856722252099921961")
            .requestEmail().build()
        val client: GoogleSignInClient = GoogleSignIn.getClient(this, googleSignOptions)
        val intent = client.signInIntent
        googleLauncher.launch(intent)
    }

    private fun validarEmail(email:String){
        isEmailOk=!email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun validarContraseña(password:String){
        isPasswordOk=password.length >=4
    }
    private fun validateInput(email: String ,password: String):Boolean{
        validarEmail(email)
        validarContraseña(password)
        return isPasswordOk && isEmailOk
    }

    companion object{
        const val SESSION_PREFERENCE: String = "SESSION_PREFERENCES"
        const val EMAIL: String = "EMAIL"
    }
}





