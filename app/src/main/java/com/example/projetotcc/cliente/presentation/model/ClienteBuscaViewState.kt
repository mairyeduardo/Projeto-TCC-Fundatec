package com.example.projetotcc.cliente.presentation.model

import com.example.projetotcc.cliente.domain.ClienteModel

sealed class ClienteBuscaViewState {

    data class Success(val cliente: ClienteModel) : ClienteBuscaViewState()

    data class NotFound(val errorMessage: String) : ClienteBuscaViewState()
}