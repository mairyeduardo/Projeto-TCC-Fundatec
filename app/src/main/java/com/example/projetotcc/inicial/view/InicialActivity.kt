package com.example.projetotcc.inicial.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityInicialBinding
import com.example.projetotcc.login.view.LoginActivity

private const val DELAY_TELA = 2000L
class InicialActivity: AppCompatActivity() {

    private lateinit var binding: ActivityInicialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicialBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        configButtonLogin()
    }

    private fun chamarTelaLogin(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@InicialActivity, LoginActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun configButtonLogin(){
        binding.buttonEntrar.setOnClickListener{
            chamarTelaLogin()
        }
    }

}