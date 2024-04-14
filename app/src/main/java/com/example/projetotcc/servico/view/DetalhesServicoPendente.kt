package com.example.projetotcc.servico.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.bumptech.glide.Glide
import com.example.projetotcc.R
import com.example.projetotcc.cliente.view.ClienteActivity
import com.example.projetotcc.databinding.ActivityDetalhesServicoPendenteBinding
import com.example.projetotcc.home.domain.ServicoModel
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.relatorio.view.RelatorioActivity
import com.example.projetotcc.servico.presentation.DetalhesServicoPendenteViewModel
import com.example.projetotcc.servico.presentation.model.ServicoPendenteViewState
import com.example.projetotcc.showSnackBar

private const val DELAY_TELA = 1000L

class DetalhesServicoPendente : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesServicoPendenteBinding
    private val detalhesServicosViewModel: DetalhesServicoPendenteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesServicoPendenteBinding.inflate(layoutInflater)
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
        binding.textNomeCliente.text = servico.nomeCliente
        Log.e("teste", servico.toString())

        binding.buttonExcluir.setOnClickListener {
            detalhesServicosViewModel.deletarTarefa(servico.id)
            detalhesServicosViewModel.state.observe(this) {
                when(it) {

                    is ServicoPendenteViewState.ShowHomeScreen -> {
                        chamarTelaHome()
                        showSnackBar(
                            binding.root,
                            R.string.app_detalhesServico_BotaoExcluir_sucesso,
                            R.color.MensagemVerdeSucesso
                        )
                    }

                    is ServicoPendenteViewState.ShowExcluirError -> showSnackBar(
                        binding.root,
                        R.string.app_detalhesServico_BotaoExcluir_error,
                        R.color.MensagemVermelhoError
                    )

                    is ServicoPendenteViewState.ShowFinalizarError -> TODO()
                }
            }

        }


        binding.buttonFinalizarServico.setOnClickListener {
            detalhesServicosViewModel.finalizarTarefa(servico.id)
            detalhesServicosViewModel.state.observe(this) {
                when(it) {

                    is ServicoPendenteViewState.ShowHomeScreen -> {
                        chamarTelaHome()
                        showSnackBar(
                            binding.root,
                            R.string.app_detalhesServico_BotaoFinalizar_sucesso,
                            R.color.MensagemVerdeSucesso
                        )
                    }

                    is ServicoPendenteViewState.ShowFinalizarError -> showSnackBar(
                        binding.root,
                        R.string.app_detalhesServico_BotaoFinalizar_error,
                        R.color.MensagemVermelhoError
                    )

                    is ServicoPendenteViewState.ShowExcluirError -> TODO()
                }
            }
        }

        configurarBotaoAdicionarCusto()
        configurarBotaoRelatorio()
        configurarBotaoCliente()
        configurarBotaoHome()

    }

    private fun chamarTelaCliente() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@DetalhesServicoPendente, ClienteActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaRelatorio() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@DetalhesServicoPendente, RelatorioActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@DetalhesServicoPendente, HomeActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaAdicionarCusto() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@DetalhesServicoPendente, AdicionarCustoActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun configurarBotaoAdicionarCusto() {
        binding.buttonAdicionarCusto.setOnClickListener {
            chamarTelaAdicionarCusto()
        }
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