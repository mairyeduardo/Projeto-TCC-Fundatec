package com.example.projetotcc.servico.presentation.model

sealed class ServicoPendenteViewState {

    object ShowHomeScreen: ServicoPendenteViewState()

    object ShowExcluirError: ServicoPendenteViewState()

    object ShowFinalizarError: ServicoPendenteViewState()
}