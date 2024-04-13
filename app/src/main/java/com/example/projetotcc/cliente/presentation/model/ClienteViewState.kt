package com.example.projetotcc.cliente.presentation.model

import com.example.projetotcc.cliente.domain.ClienteModel

sealed class ClienteViewState {

    data class Success(val list: List<ClienteModel>) : ClienteViewState()

    object ShowLoading : ClienteViewState()

    object StopLoading: ClienteViewState()

    data class Error(val errorMessage: String) : ClienteViewState()
}