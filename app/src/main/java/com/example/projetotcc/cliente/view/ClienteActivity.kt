package com.example.projetotcc.cliente.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityClienteBinding
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.relatorio.view.RelatorioActivity

private const val DELAY_TELA = 1000L

class ClienteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClienteBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        configurarBotaoRelatorio()
        configurarBotaoHome()
    }

    private fun chamarTelaRelatorio() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@ClienteActivity, RelatorioActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@ClienteActivity, HomeActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun configurarBotaoRelatorio() {
        binding.ivRelatorio.setOnClickListener {
            chamarTelaRelatorio()
        }
    }

    private fun configurarBotaoHome() {
        binding.ivServico.setOnClickListener{
            chamarTelaHome()
        }
    }

}