package com.example.projetotcc.servico.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotcc.servico.domain.ServicoUseCase
import com.example.projetotcc.servico.presentation.model.NovoServicoViewState
import kotlinx.coroutines.launch

class NovoServicoViewModel : ViewModel() {

    private val useCase by lazy {
        ServicoUseCase()
    }

    private val viewState: MutableLiveData<NovoServicoViewState> = MutableLiveData()
    val state: LiveData<NovoServicoViewState> = viewState

    fun validarPreenchimentoDoServico(
        titulo: String,
        descricao: String?,
        valorServico: String,
        custoAtual: String?,
        dataInicio: String,
        enderecoServico: String,
        nome: String,
        telefone: String,
        enderecoCliente: String,
    ) {

        if (titulo.isNullOrBlank() && valorServico.isNullOrBlank() && dataInicio.isNullOrBlank() && enderecoServico.isNullOrBlank() && nome.isNullOrBlank() && telefone.isNullOrBlank() && enderecoCliente.isNullOrBlank()) {

        } else if (titulo.isNullOrBlank()) {
            viewState.value = NovoServicoViewState.ShowTituloError
            return
        } else if (valorServico.isNullOrBlank()) {
            viewState.value = NovoServicoViewState.ShowValorError
            return
        } else if (dataInicio.isNullOrBlank()) {
            viewState.value = NovoServicoViewState.ShowDataInicioError
            return
        } else if (enderecoServico.isNullOrBlank()) {
            viewState.value = NovoServicoViewState.ShowEnderecoError
            return
        } else if (nome.isNullOrBlank()) {
            viewState.value = NovoServicoViewState.ShowNomeClienteError
            return
        } else if (telefone.isNullOrBlank()) {
            viewState.value = NovoServicoViewState.ShowTelefoneClienteError
            return
        } else if (enderecoCliente.isNullOrBlank()) {
            viewState.value = NovoServicoViewState.ShowEnderecoClienteError
            return
        } else {
            viewModelScope.launch {
                val isSuccess = useCase.criarServico(
                    titulo = titulo,
                    descricao = descricao,
                    valorServico = valorServico.toDouble(),
                    custoAtual = custoAtual?.toDouble(),
                    dataInicio = dataInicio,
                    enderecoServico = enderecoServico,
                    nome = nome,
                    telefone = telefone,
                    enderecoCliente = enderecoCliente,
                )
                if (isSuccess) {
                    viewState.value = NovoServicoViewState.ShowHomeScreen
                } else {
                    viewState.value = NovoServicoViewState.ShowGeralError
                }
            }
        }

    }

}