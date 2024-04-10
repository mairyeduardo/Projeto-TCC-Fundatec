package com.example.projetotcc.home.presentation.model

import com.example.projetotcc.home.domain.ServicoModel

sealed class HomeViewState {

    data class Success(val list: List<ServicoModel>) : HomeViewState()

    object ShowLoading : HomeViewState()

    object StopLoading : HomeViewState()

    data class Error(val errorMessage: String) : HomeViewState()

}