package com.example.projetotcc.relatorio.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotcc.relatorio.domain.RelatorioUseCase
import com.example.projetotcc.relatorio.domain.toModel
import com.example.projetotcc.relatorio.presentation.model.RelatorioViewState
import kotlinx.coroutines.launch

class RelatorioViewModel: ViewModel() {

    private val useCase by lazy {
        RelatorioUseCase()
    }

    private val viewState: MutableLiveData<RelatorioViewState> = MutableLiveData()
    val state: LiveData<RelatorioViewState> = viewState


    fun gerarRelatorioPorIdTarefa(idTarefa: Int) {
        viewModelScope.launch {
            val relatorio = useCase.gerarRelatorioPorIdTarefa(idTarefa)
            if (relatorio != null) {
                viewState.value = RelatorioViewState.Success(relatorio.toModel())
            } else {
                viewState.value = RelatorioViewState.NotFound
            }
        }
    }

    fun buscarRelatorioPorIdTarefa(idTarefa: Int) {
        viewModelScope.launch {
            val relatorio = useCase.buscarRelatorioPorIdTarefa(idTarefa)
            if (relatorio != null) {
                viewState.value = RelatorioViewState.Success(relatorio.toModel())
            } else {
                viewState.value = RelatorioViewState.NotFound
            }
        }
    }

}