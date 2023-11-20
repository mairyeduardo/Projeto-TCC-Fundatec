package com.example.projetotcc.login.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.R
import com.example.projetotcc.databinding.ActivityLoginBinding
import com.example.projetotcc.home.view.HomeActivity
import com.example.projetotcc.login.presentation.LoginViewModel
import com.example.projetotcc.login.presentation.model.LoginViewState
import com.example.projetotcc.showError
import com.example.projetotcc.showSnackBar


class LoginActivity: AppCompatActivity()  {

    private lateinit var binding: ActivityLoginBinding

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        configButtonLogin()

        this.applicationContext


    }

    private fun configButtonLogin() {
        binding.buttonLogin.setOnClickListener{
            loginViewModel.validacaoPreenchimento(
                binding.loginEmail.text.toString(),
                binding.loginSenha.text.toString()
            )
        }
        loginViewModel.state.observe(this) {
            when(it) {
                LoginViewState.ShowEmailError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroEmailLogin,
                    R.color.MensagemVermelhoError
                )

                LoginViewState.ShowPasswordError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroPasswordLogin,
                    R.color.MensagemVermelhoError
                )

                LoginViewState.ShowHomeScreen -> chamarTelaHome()

                LoginViewState.ShowEmailPasswordError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroLogin,
                    R.color.MensagemVermelhoError
                )

                LoginViewState.ShowError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroLoginInvalido,
                    R.color.MensagemVermelhoError
                )
            }
        }

    }

    private fun chamarTelaHome() {
        showSnackBar(
            binding.root,
            R.string.app_mensagem_sucessoLogin,
            R.color.MensagemVerdeSucesso
        )
        val handle = Handler()
        handle.postDelayed({
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }, 3000)

    }


}