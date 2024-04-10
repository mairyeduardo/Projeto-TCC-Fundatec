package com.example.projetotcc.home.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.R
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.projetotcc.cliente.view.ClienteActivity
import com.example.projetotcc.databinding.ActivityHomeBinding
import com.example.projetotcc.databinding.ActivityLoginBinding
import com.example.projetotcc.gone
import com.example.projetotcc.home.domain.ServicoModel
import com.example.projetotcc.home.presentation.HomeViewModel
import com.example.projetotcc.home.presentation.model.HomeViewState
import com.example.projetotcc.relatorio.view.RelatorioActivity
import com.example.projetotcc.servico.view.DetalhesServicoConcluido
import com.example.projetotcc.servico.view.DetalhesServicoPendente
import com.example.projetotcc.servico.view.NovoServicoActivity
import com.example.projetotcc.visible

private const val DELAY_TELA = 1000L

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private val adapter: ServicoListAdapter by lazy {
        ServicoListAdapter() {
            Log.e("Home Activity", it.toString())
            chamarTelaDetalhesDoServicoPendente(it)
            chamarTelaDetalhesDoServicoConcluido(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)


        binding.listagemPendentes.adapter = adapter
        viewModel.state.observe(this) {
            when (it) {
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

        configurarBotaoRelatorio()
        configurarBotaoCliente()
        configurarBotaoNovoServico()
    }


    private fun chamarTelaRelatorio() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@HomeActivity, RelatorioActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaCliente() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@HomeActivity, ClienteActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaDetalhesDoServicoPendente(servicoModel: ServicoModel) {
        val intent = Intent(this@HomeActivity, DetalhesServicoPendente::class.java)
        intent.putExtra("servico",servicoModel)
        startActivity(intent)
    }

    private fun chamarTelaDetalhesDoServicoConcluido(servicoModel: ServicoModel) {
        val intent = Intent(this@HomeActivity, DetalhesServicoConcluido::class.java)
        intent.putExtra("servico",servicoModel)
        startActivity(intent)
    }

    private fun chamarTelaNovoServico() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@HomeActivity, NovoServicoActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun configurarBotaoRelatorio() {
        binding.ivRelatorio.setOnClickListener {
            chamarTelaRelatorio()
        }
    }

    private fun configurarBotaoCliente() {
        binding.ivCliente.setOnClickListener {
            chamarTelaCliente()
        }
    }

    private fun configurarBotaoNovoServico() {
        binding.botaoNovoServico.setOnClickListener {
            chamarTelaNovoServico()
        }
    }
}