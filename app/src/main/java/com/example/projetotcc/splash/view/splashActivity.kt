package com.example.projetotcc.splash.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivitySplashBinding
import com.example.projetotcc.inicial.view.InicialActivity


private const val DELAY_TELA = 3000L
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)
        val handle = Handler()
        handle.postDelayed({ chamarTelaInicial() }, 3000)
    }



    private fun chamarTelaInicial(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, InicialActivity::class.java)
            startActivity(intent)
            finish()
        }, DELAY_TELA)
    }
}