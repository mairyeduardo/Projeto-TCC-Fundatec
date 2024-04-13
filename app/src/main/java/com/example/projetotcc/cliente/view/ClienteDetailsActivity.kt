package com.example.projetotcc.cliente.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.cliente.domain.ClienteModel
import com.example.projetotcc.databinding.ActivityClienteDetailsBinding
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.relatorio.view.RelatorioActivity

private const val DELAY_TELA = 1000L

class ClienteDetailsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityClienteDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClienteDetailsBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        val cliente = intent.extras?.getSerializable("cliente") as? ClienteModel
        if (cliente == null) {
            finish()
            return
        }
        binding.textoNome.text = cliente.nome
        binding.textoTelefone.text = cliente.telefone
        binding.textoEndereco.text = cliente.enderecoPrincipal
        Log.e("teste", cliente.toString())



        configurarBotaoRelatorio()
        configurarBotaoHome()
        configurarBotaoCliente()
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

    private fun configurarBotaoCliente() {
        binding.ivCliente.setOnClickListener {
            chamarTelaCliente()
        }
    }

    private fun chamarTelaRelatorio() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@ClienteDetailsActivity, RelatorioActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@ClienteDetailsActivity, HomeActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaCliente() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@ClienteDetailsActivity, ClienteActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

}