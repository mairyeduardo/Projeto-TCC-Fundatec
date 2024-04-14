package com.example.projetotcc.cliente.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotcc.cliente.domain.ClienteUseCase
import com.example.projetotcc.cliente.domain.toModelNoList
import com.example.projetotcc.cliente.presentation.model.ClienteBuscaViewState
import kotlinx.coroutines.launch

class ClienteBuscaViewModel: ViewModel() {

    private val useCase by lazy {
        ClienteUseCase()
    }

    private val viewState: MutableLiveData<ClienteBuscaViewState> = MutableLiveData()
    val state: LiveData<ClienteBuscaViewState> = viewState

    fun buscarClientePorNome(nomeCliente: String){
        viewModelScope.launch {
            val cliente = useCase.buscarClientesPorNomeUtilizandoIdUsuario(nomeCliente)
            if (cliente != null) {
                viewState.value = ClienteBuscaViewState.Success(cliente.toModelNoList())
            } else {
                viewState.value = ClienteBuscaViewState.NotFound("Nenhum cliente com este nome cadastrado")
            }
        }
    }


}