package com.example.projetotcc.servico.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.cliente.view.ClienteActivity
import com.example.projetotcc.databinding.ActivityNovoServicoBinding
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.relatorio.view.RelatorioActivity

private const val DELAY_TELA = 1000L

class NovoServicoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNovoServicoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNovoServicoBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        configurarBotaoRelatorio()
        configurarBotaoHome()
        configurarBotaoCliente()
    }

    private fun chamarTelaRelatorio() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@NovoServicoActivity, RelatorioActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@NovoServicoActivity, HomeActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaCliente() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@NovoServicoActivity, ClienteActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun configurarBotaoRelatorio() {
        binding.ivRelatorio.setOnClickListener {
            chamarTelaRelatorio()
        }
    }

    private fun configurarBotaoHome() {
        binding.ivServico.setOnClickListener {
            chamarTelaHome()
        }
    }

    private fun configurarBotaoCliente() {
        binding.ivCliente.setOnClickListener {
            chamarTelaCliente()
        }
    }
}