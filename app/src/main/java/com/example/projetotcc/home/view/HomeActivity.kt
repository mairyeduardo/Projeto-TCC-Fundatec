package com.example.projetotcc.home.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityHomeBinding
import com.example.projetotcc.databinding.ActivityLoginBinding
import com.example.projetotcc.relatorio.view.RelatorioActivity

private const val DELAY_TELA = 1000L
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        configurarBotaoRelatorio()
    }

    private fun chamarTelaRelatorio() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@HomeActivity, RelatorioActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun configurarBotaoRelatorio() {
        binding.ivRelatorio.setOnClickListener {
            chamarTelaRelatorio()
        }
    }
}