package com.example.webview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webview.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sessionManager = SessionManager(this)

        binding.btnLogin.setOnClickListener{
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()

            if(name.isEmpty()){
                binding.edtName.error = "Harap Masukan Nama"
            }

            if(email.isEmpty()){
                binding.edtEmail.error = "Harap Masukan Email"
            }

            if(name == "asep" && email == "asepcahya.nugraha75@gmail.com"){
                sessionManager.sessionLogin(name, email)
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Nama / Email Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}