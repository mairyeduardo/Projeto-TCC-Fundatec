package com.example.projetotcc.relatorio.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.cliente.view.ClienteActivity
import com.example.projetotcc.databinding.ActivityRelatorioBinding

import com.example.projetotcc.gone
import com.example.projetotcc.home.domain.ServicoModel
import com.example.projetotcc.home.presentation.HomeViewModelConcluidos
import com.example.projetotcc.home.presentation.model.HomeViewState
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.home.view.ServicoListAdapter
import com.example.projetotcc.servico.view.DetalhesServicoConcluido
import com.example.projetotcc.visible

private const val DELAY_TELA = 1000L

class RelatorioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRelatorioBinding
    private val viewModelConcluidos: HomeViewModelConcluidos by viewModels()

    private val adapterConcluidos: ServicoListAdapter by lazy {
        ServicoListAdapter() {
            Log.e("Relatorio Activity", it.toString())
            chamarTelaDetalhesDoServicoConcluido(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRelatorioBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        binding.listagemConcluidos.adapter = adapterConcluidos

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

        configurarBotaoCliente()
        configurarBotaoHome()
    }

    private fun chamarTelaHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@RelatorioActivity, HomeActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaDetalhesDoServicoConcluido(servicoModel: ServicoModel) {
        val intent = Intent(this@RelatorioActivity, DetalhesServicoConcluido::class.java)
        intent.putExtra("servico",servicoModel)
        startActivity(intent)
    }

    private fun chamarTelaCliente() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@RelatorioActivity, ClienteActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun configurarBotaoHome() {
        binding.ivServico.setOnClickListener {
            chamarTelaHome()
        }
    }

    private fun configurarBotaoCliente() {
        binding.ivCliente.setOnClickListener{
            chamarTelaCliente()
        }
    }

}