package com.example.projetotcc.cadastro.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.R
import com.example.projetotcc.cadastro.presentation.CadastroViewModel
import com.example.projetotcc.cadastro.presentation.model.CadastroViewState
import com.example.projetotcc.databinding.ActivityCadastroBinding
import com.example.projetotcc.login.view.LoginActivity
import com.example.projetotcc.showError
import com.example.projetotcc.showSnackBar

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private val cadastroViewModel: CadastroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)
        configurarBotaoCriar()
    }

    private fun configurarBotaoCriar() {

        binding.buttonCadastro.setOnClickListener {
            cadastroViewModel.validacaoPreenchimento(
                binding.cadastroUsername.text.toString(),
                binding.cadastroEmail.text.toString(),
                binding.cadastroSenha.text.toString()
            )
        }
        cadastroViewModel.state.observe(this) {
            when (it) {
                CadastroViewState.ShowNameError ->
                    binding.cadastroUsername.showError(R.string.app_mensagem_erroNomeOnboarding)

                CadastroViewState.ShowEmailError ->
                    binding.cadastroEmail.showError(R.string.app_mensagem_erroEmailOnboarding)

                CadastroViewState.ShowPasswordError ->
                    binding.cadastroSenha.showError(R.string.app_mensagem_erroPasswordOnboarding)

                CadastroViewState.ShowGeralError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroGeralCriacao,
                    R.color.MensagemVermelhoError
                )

                CadastroViewState.ShowLoginScreen ->
                    chamarTelaLogin()

                CadastroViewState.ShowNameEmailPasswordError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroCamposCriacao,
                    R.color.MensagemVermelhoError
                )
            }
        }
    }

    private fun chamarTelaLogin() {
        showSnackBar(
            binding.root,
            R.string.app_mensagem_sucessoCriacao,
            R.color.MensagemVerdeSucesso
        )
        val handle = Handler()
        handle.postDelayed({
            val intent = Intent(this@CadastroActivity, LoginActivity::class.java)
            startActivity(intent)
        }, 3000)
    }

}