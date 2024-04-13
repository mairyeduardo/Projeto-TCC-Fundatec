package com.example.projetotcc.cliente.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotcc.cliente.domain.ClienteUseCase
import com.example.projetotcc.cliente.domain.toModel
import com.example.projetotcc.cliente.presentation.model.ClienteViewState
import kotlinx.coroutines.launch

class ClienteViewModel: ViewModel() {

    private val useCase by lazy {
        ClienteUseCase()
    }

    private val viewState: MutableLiveData<ClienteViewState> = MutableLiveData()
    val state: LiveData<ClienteViewState> = viewState

    private fun buscarClientes() {
        viewState.value = ClienteViewState.ShowLoading
        viewModelScope.launch {
            val listarClientes = useCase.buscarClientesPorIdUsuario()
            if (listarClientes.isNotEmpty()) {
                viewState.value = ClienteViewState.Success(listarClientes.toModel())
            } else {
                viewState.value = ClienteViewState.Error("Lista de clientes vazia")
            }
            viewState.value = ClienteViewState.StopLoading
        }
    }

    init {
        buscarClientes()
    }
}