package com.example.projetotcc.cliente.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.cliente.domain.ClienteModel
import com.example.projetotcc.cliente.presentation.ClienteDetailsViewModel
import com.example.projetotcc.cliente.presentation.ClienteDetailsViewModelConcluidos
import com.example.projetotcc.databinding.ActivityClienteDetailsBinding
import com.example.projetotcc.gone
import com.example.projetotcc.home.domain.ServicoModel
import com.example.projetotcc.home.presentation.model.HomeViewState
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.home.view.ServicoListAdapter
import com.example.projetotcc.relatorio.view.RelatorioActivity
import com.example.projetotcc.servico.view.DetalhesServicoConcluido
import com.example.projetotcc.servico.view.DetalhesServicoPendente
import com.example.projetotcc.visible

private const val DELAY_TELA = 1000L

class ClienteDetailsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityClienteDetailsBinding
    private val viewModel: ClienteDetailsViewModel by viewModels()
    private val viewModelConcluidos: ClienteDetailsViewModelConcluidos by viewModels()

    private val adapter: ServicoListAdapter by lazy {
        ServicoListAdapter() {
            Log.e("Cliente Details Activity", it.toString())
            chamarTelaDetalhesDoServicoPendente(it)
        }
    }

    private val adapterConcluidos: ServicoListAdapter by lazy {
        ServicoListAdapter() {
            Log.e("Cliente Details Activity", it.toString())
            chamarTelaDetalhesDoServicoConcluido(it)
        }
    }

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

        binding.listagemPendentes.adapter = adapter
        viewModel.buscarServicosPendentesDoCliente(cliente.id)
        viewModel.state.observe(this) {
            when(it) {
                is HomeViewState.Success ->
                    adapter.addList(
                        it.list
                    )

                is HomeViewState.Error ->
                    it.errorMessage

                HomeViewState.ShowLoading -> {
                    binding.progressBar.visible()
                }
                HomeViewState.StopLoading -> {
                    binding.progressBar.gone()
                }

            }
        }

        binding.listagemConcluidos.adapter = adapterConcluidos
        viewModelConcluidos.buscarServicosConcluidosDoCliente(cliente.id)
        viewModelConcluidos.state.observe(this) {
            when(it) {
                is HomeViewState.Success ->
                    adapterConcluidos.addList(
                        it.list
                    )

                is HomeViewState.Error ->
                    it.errorMessage

                HomeViewState.ShowLoading -> {
                    binding.progressBar.visible()
                }
                HomeViewState.StopLoading -> {
                    binding.progressBar.gone()
                }
            }
        }

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

    private fun chamarTelaDetalhesDoServicoPendente(servicoModel: ServicoModel) {
        val intent = Intent(this@ClienteDetailsActivity, DetalhesServicoPendente::class.java)
        intent.putExtra("servico",servicoModel)
        startActivity(intent)
    }

    private fun chamarTelaDetalhesDoServicoConcluido(servicoModel: ServicoModel) {
        val intent = Intent(this@ClienteDetailsActivity, DetalhesServicoConcluido::class.java)
        intent.putExtra("servico",servicoModel)
        startActivity(intent)
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