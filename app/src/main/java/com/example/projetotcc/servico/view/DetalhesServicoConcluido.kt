package com.example.projetotcc.servico.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.example.projetotcc.R
import com.example.projetotcc.cliente.view.ClienteActivity
import com.example.projetotcc.databinding.ActivityDetalhesServicoConcluidoBinding
import com.example.projetotcc.home.domain.ServicoModel
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.relatorio.domain.RelatorioModel
import com.example.projetotcc.relatorio.presentation.RelatorioViewModel
import com.example.projetotcc.relatorio.presentation.model.RelatorioViewState
import com.example.projetotcc.relatorio.view.RelatorioActivity
import com.example.projetotcc.relatorio.view.RelatorioDetailsActivity
import com.example.projetotcc.showSnackBar


private const val DELAY_TELA = 1000L

class DetalhesServicoConcluido : AppCompatActivity(){

    private lateinit var binding: ActivityDetalhesServicoConcluidoBinding
    private val relatorioViewModel: RelatorioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesServicoConcluidoBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        val servico = intent.extras?.getSerializable("servico") as? ServicoModel
        if (servico == null) {
            finish()
            return
        }
        binding.textTitulo.text = servico.titulo
        binding.textDescricao.text = servico.descricao
        binding.textEndereco.text = servico.enderecoServico
        binding.textValor.text = servico.valorServico.toString()
        binding.textCusto.text = servico.custoAtual.toString()
        binding.textData.text = servico.dataInicio
        binding.textDataFim.text = servico.dataFinal
        binding.textNomeCliente.text = servico.nomeCliente
        Log.e("teste", servico.toString())

        binding.buttonGerarRelatorio.setOnClickListener {
            relatorioViewModel.gerarRelatorioPorIdTarefa(servico.id)
            relatorioViewModel.state.observe(this) {
                when(it) {
                    is RelatorioViewState.Success -> {
                        val relatorioModel = RelatorioModel(
                            id = it.relatorio.id,
                            idTarefa = it.relatorio.idTarefa,
                            tituloTarefa = it.relatorio.tituloTarefa,
                            descricaoTarefa = it.relatorio.descricaoTarefa,
                            valorServico = it.relatorio.valorServico,
                            custoAtual = it.relatorio.custoAtual,
                            dataInicio = it.relatorio.dataInicio,
                            dataFinal = it.relatorio.dataFinal,
                            totalDeDias = it.relatorio.totalDeDias,
                            enderecoServico = it.relatorio.enderecoServico,
                            nomeCliente = it.relatorio.nomeCliente,
                            valorLiquido = it.relatorio.valorLiquido

                        )
                        chamarTelaDetalhesDoRelatorio(relatorioModel)
                    }


                    is RelatorioViewState.NotFound -> {
                        relatorioViewModel.buscarRelatorioPorIdTarefa(servico.id)
                        relatorioViewModel.state.observe(this) {
                            when(it) {

                                is RelatorioViewState.Success -> {
                                    val relatorioModel = RelatorioModel(
                                        id = it.relatorio.id,
                                        idTarefa = it.relatorio.idTarefa,
                                        tituloTarefa = it.relatorio.tituloTarefa,
                                        descricaoTarefa = it.relatorio.descricaoTarefa,
                                        valorServico = it.relatorio.valorServico,
                                        custoAtual = it.relatorio.custoAtual,
                                        dataInicio = it.relatorio.dataInicio,
                                        dataFinal = it.relatorio.dataFinal,
                                        totalDeDias = it.relatorio.totalDeDias,
                                        enderecoServico = it.relatorio.enderecoServico,
                                        nomeCliente = it.relatorio.nomeCliente,
                                        valorLiquido = it.relatorio.valorLiquido
                                    )
                                    chamarTelaDetalhesDoRelatorio(relatorioModel)
                                }

                                RelatorioViewState.NotFound -> showSnackBar(
                                    binding.root,
                                    R.string.app_relatorioDetails_busca_error,
                                    R.color.MensagemVermelhoError

                                )

                            }
                        }
                    }
                }
            }
        }


        configurarBotaoRelatorio()
        configurarBotaoCliente()
        configurarBotaoHome()

    }


    private fun chamarTelaDetalhesDoRelatorio(relatorioModel: RelatorioModel) {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@DetalhesServicoConcluido, RelatorioDetailsActivity::class.java)
            intent.putExtra("relatorio", relatorioModel)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaCliente() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@DetalhesServicoConcluido, ClienteActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaRelatorio() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@DetalhesServicoConcluido, RelatorioActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@DetalhesServicoConcluido, HomeActivity::class.java)
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

    private fun configurarBotaoHome() {
        binding.ivServico.setOnClickListener {
            chamarTelaHome()
        }
    }


}