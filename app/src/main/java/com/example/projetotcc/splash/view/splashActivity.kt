package com.example.projetotcc.splash.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivitySplashBinding
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.inicial.view.InicialActivity
import com.example.projetotcc.splash.view.presentation.SplashViewModel
import com.example.projetotcc.splash.view.presentation.model.SplashViewState


private const val DELAY_TELA = 3000L
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        viewModel.state.observe(this) { state ->
            when (state) {
                SplashViewState.ShowLogin -> chamarTelaInicial()
                SplashViewState.ShowHome -> chamarTelaHome()
            }
        }
    }



    private fun chamarTelaInicial(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, InicialActivity::class.java)
            startActivity(intent)
            finish()
        }, DELAY_TELA)
    }

    private fun chamarTelaHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, DELAY_TELA)
    }
}