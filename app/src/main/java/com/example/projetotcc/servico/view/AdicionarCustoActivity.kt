package com.example.projetotcc.servico.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.R
import com.example.projetotcc.cliente.view.ClienteActivity
import com.example.projetotcc.databinding.ActivityCustoServicoBinding
import com.example.projetotcc.home.domain.ServicoModel
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.relatorio.view.RelatorioActivity
import com.example.projetotcc.servico.presentation.DetalhesServicoPendenteViewModel
import com.example.projetotcc.servico.presentation.model.ServicoPendenteViewState
import com.example.projetotcc.showSnackBar

private const val DELAY_TELA = 1000L

class AdicionarCustoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustoServicoBinding
    private val detalhesServicoViewModel: DetalhesServicoPendenteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustoServicoBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        val servico = intent.extras?.getSerializable("servico") as? ServicoModel
        if (servico == null) {
            finish()
            return
        }

        binding.buttonAdicionarCusto.setOnClickListener {
            detalhesServicoViewModel.adicionarCustoTarefa(servico.id, binding.custo.text.toString())
            detalhesServicoViewModel.state.observe(this) {
                when(it) {

                    is ServicoPendenteViewState.ShowHomeScreen -> {
                        chamarTelaHome()
                        showSnackBar(
                            binding.root,
                            R.string.app_adicionarCusto_Adicionar_sucesso,
                            R.color.MensagemVerdeSucesso
                        )
                    }

                    is ServicoPendenteViewState.ShowAdicionarError -> showSnackBar(
                        binding.root,
                        R.string.app_adicionarCusto_Adicionar_error,
                        R.color.MensagemVermelhoError
                    )



                    is ServicoPendenteViewState.ShowExcluirError -> TODO()
                    is ServicoPendenteViewState.ShowFinalizarError -> TODO()


                }
            }
        }


        configurarBotaoRelatorio()
        configurarBotaoHome()
        configurarBotaoCliente()
    }

    private fun chamarTelaRelatorio() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@AdicionarCustoActivity, RelatorioActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@AdicionarCustoActivity, HomeActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaCliente() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@AdicionarCustoActivity, ClienteActivity::class.java)
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