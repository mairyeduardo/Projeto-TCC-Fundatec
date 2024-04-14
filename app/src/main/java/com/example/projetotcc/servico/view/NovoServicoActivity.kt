package com.example.projetotcc.servico.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.R
import com.example.projetotcc.cliente.presentation.ClienteBuscaViewModel
import com.example.projetotcc.cliente.presentation.model.ClienteBuscaViewState
import com.example.projetotcc.cliente.view.ClienteActivity
import com.example.projetotcc.databinding.ActivityNovoServicoBinding
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.relatorio.view.RelatorioActivity
import com.example.projetotcc.servico.presentation.NovoServicoViewModel
import com.example.projetotcc.servico.presentation.model.NovoServicoViewState
import com.example.projetotcc.showError
import com.example.projetotcc.showSnackBar

private const val DELAY_TELA = 1000L

class NovoServicoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNovoServicoBinding
    private val novoServicoViewModel: NovoServicoViewModel by viewModels()
    private val buscaViewModel: ClienteBuscaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNovoServicoBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        binding.ftButtonPesquisa.setOnClickListener{
            buscaViewModel.buscarClientePorNome(binding.pesquisa.text.toString())
            buscaViewModel.state.observe(this) {
                when(it) {
                    is ClienteBuscaViewState.Success -> {
                        binding.nome.setText(it.cliente.nome)
                        binding.telefone.setText(it.cliente.telefone)
                        binding.endereco.setText(it.cliente.enderecoPrincipal)
                    }

                    is ClienteBuscaViewState.NotFound ->
                        it.errorMessage
                }
            }
        }

        configurarBotaoCriarServico()
        configurarBotaoRelatorio()
        configurarBotaoHome()
        configurarBotaoCliente()
    }


    private fun configurarBotaoBusca() {

    }

    private fun configurarBotaoCriarServico() {
        binding.buttonCriarServico.setOnClickListener{
            novoServicoViewModel.validarPreenchimentoDoServico(
                binding.titulo.text.toString(),
                binding.descricao.text.toString(),
                binding.valor.text.toString(),
                binding.gasto.text.toString(),
                binding.inicio.text.toString(),
                binding.enderecoS.text.toString(),
                binding.nome.text.toString(),
                binding.telefone.text.toString(),
                binding.endereco.text.toString()
            )
        }
        novoServicoViewModel.state.observe(this) {
            when (it) {

                NovoServicoViewState.ShowTituloError ->
                    binding.titulo.showError(R.string.app_novoServico_titulo_error)

                NovoServicoViewState.ShowDescricaoError ->
                    binding.descricao.showError(R.string.app_novoServico_descricao_error)

                NovoServicoViewState.ShowValorError ->
                    binding.valor.showError(R.string.app_novoServico_valorServico_error)

                NovoServicoViewState.ShowCustoAtualError ->
                    binding.gasto.showError(R.string.app_novoServico_custoAtual_error)

                NovoServicoViewState.ShowEnderecoError ->
                    binding.enderecoS.showError(R.string.app_novoServico_enderecoServico_error)

                NovoServicoViewState.ShowDataInicioError ->
                    binding.inicio.showError(R.string.app_novoServico_dataInicio_error)

                NovoServicoViewState.ShowNomeClienteError ->
                    binding.nome.showError(R.string.app_novoServico_nomeCliente_error)

                NovoServicoViewState.ShowTelefoneClienteError ->
                    binding.telefone.showError(R.string.app_novoServico_telefoneCliente_error)

                NovoServicoViewState.ShowEnderecoClienteError ->
                    binding.endereco.showError(R.string.app_novoServico_enderecoCliente_error)

                NovoServicoViewState.ShowGeralError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroCamposCriacao,
                    R.color.MensagemVermelhoError
                )

                NovoServicoViewState.ShowHomeScreen ->
                    chamarTelaHome()


            }
        }
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