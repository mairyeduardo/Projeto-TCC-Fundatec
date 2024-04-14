package com.example.projetotcc.cliente.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotcc.cliente.domain.ClienteModel
import com.example.projetotcc.home.domain.toModel
import com.example.projetotcc.home.presentation.model.HomeViewState
import com.example.projetotcc.servico.domain.ServicoUseCase
import kotlinx.coroutines.launch

class ClienteDetailsViewModel: ViewModel() {

    private val useCase by lazy {
        ServicoUseCase()
    }

    private val viewState: MutableLiveData<HomeViewState> = MutableLiveData()
    val state: LiveData<HomeViewState> = viewState

    fun buscarServicosPendentesDoCliente(idCliente: Int) {
        viewState.value = HomeViewState.ShowLoading
        viewModelScope.launch {
            val listarServicos = useCase.buscarTarefasPendentesPorIdCliente(idCliente)
            if (listarServicos.isNotEmpty()) {
                viewState.value = HomeViewState.Success(listarServicos.toModel())
            } else {
                viewState.value = HomeViewState.Error("Lista de servicos Pendentes vazia")
            }
            viewState.value = HomeViewState.StopLoading
        }
    }

}