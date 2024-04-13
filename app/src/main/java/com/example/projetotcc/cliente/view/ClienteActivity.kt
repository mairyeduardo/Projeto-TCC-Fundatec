package com.example.projetotcc.cliente.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.cliente.domain.ClienteModel
import com.example.projetotcc.cliente.presentation.ClienteViewModel
import com.example.projetotcc.cliente.presentation.model.ClienteViewState
import com.example.projetotcc.databinding.ActivityClienteBinding
import com.example.projetotcc.gone
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.relatorio.view.RelatorioActivity
import com.example.projetotcc.visible

private const val DELAY_TELA = 1000L

class ClienteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClienteBinding
    private val viewModel: ClienteViewModel by viewModels()

    private val adapter: ClienteListAdapter by lazy {
        ClienteListAdapter() {
            Log.e("Cliente Activity", it.toString())
            chamarTelaDetalhesDoCliente(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClienteBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        binding.listaClientes.adapter = adapter

        viewModel.state.observe(this) {
            when (it) {
                is ClienteViewState.Success ->
                    adapter.addList(
                        it.list
                    )

                is ClienteViewState.Error ->
                    it.errorMessage

                ClienteViewState.ShowLoading -> {
                    binding.progressBar.visible()
                }

                ClienteViewState.StopLoading -> {
                    binding.progressBar.gone()
                }
            }
        }


        configurarBotaoRelatorio()
        configurarBotaoHome()
    }

    private fun chamarTelaDetalhesDoCliente(clienteModel: ClienteModel) {
        val intent = Intent(this@ClienteActivity, ClienteDetailsActivity::class.java)
        intent.putExtra("clienteDetails", clienteModel)
        startActivity(intent)
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