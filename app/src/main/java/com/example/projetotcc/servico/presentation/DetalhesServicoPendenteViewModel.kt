package com.example.projetotcc.servico.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotcc.servico.domain.ServicoUseCase
import com.example.projetotcc.servico.presentation.model.ServicoPendenteViewState
import kotlinx.coroutines.launch

class DetalhesServicoPendenteViewModel: ViewModel() {


    private val useCase by lazy {
        ServicoUseCase()
    }

    private val viewState: MutableLiveData<ServicoPendenteViewState> = MutableLiveData()
    val state: LiveData<ServicoPendenteViewState> = viewState

    fun deletarTarefa (servicoId: Int) {

        viewModelScope.launch {
            val isSuccess = useCase.deletarServicoPorId(
                servicoId = servicoId
            )
            if (isSuccess) {
                viewState.value = ServicoPendenteViewState.ShowHomeScreen
            } else {
                viewState.value = ServicoPendenteViewState.ShowExcluirError
            }
        }
    }

    fun finalizarTarefa (servicoId: Int) {

        viewModelScope.launch {
            val isSuccess = useCase.finalizarTarefaPorId(
                servicoId = servicoId
            )
            if (isSuccess) {
                viewState.value = ServicoPendenteViewState.ShowHomeScreen
            } else {
                viewState.value = ServicoPendenteViewState.ShowFinalizarError
            }
        }

    }

}