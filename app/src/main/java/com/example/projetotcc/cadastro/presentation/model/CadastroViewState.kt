package com.example.projetotcc.cadastro.presentation.model

sealed class CadastroViewState {

    object ShowNameEmailPasswordError: CadastroViewState()
    object ShowGeralError: CadastroViewState()
    object ShowNameError: CadastroViewState()
    object ShowEmailError: CadastroViewState()
    object ShowPasswordError: CadastroViewState()
    object ShowLoginScreen: CadastroViewState()
}