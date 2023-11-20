package com.example.projetotcc.login.presentation.model


sealed class LoginViewState {

    object ShowEmailPasswordError: LoginViewState()

    object ShowEmailError: LoginViewState()

    object ShowError: LoginViewState()

    object ShowPasswordError: LoginViewState()

    object ShowHomeScreen: LoginViewState()
}