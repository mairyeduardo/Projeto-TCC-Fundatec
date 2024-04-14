package com.example.projetotcc.servico.presentation.model

sealed class NovoServicoViewState {

    object ShowGeralError: NovoServicoViewState()

    object ShowTituloError: NovoServicoViewState()

    object ShowValorError: NovoServicoViewState()

    object ShowEnderecoError: NovoServicoViewState()

    object ShowDataInicioError: NovoServicoViewState()

    object ShowNomeClienteError: NovoServicoViewState()

    object ShowTelefoneClienteError: NovoServicoViewState()

    object ShowEnderecoClienteError: NovoServicoViewState()

    object ShowHomeScreen: NovoServicoViewState()

}