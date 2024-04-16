package com.example.projetotcc.splash.view.presentation.model

sealed class SplashViewState {
    object ShowLogin : SplashViewState()
    object ShowHome : SplashViewState()
}