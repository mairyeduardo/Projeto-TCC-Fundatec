package com.example.projetotcc.servico.domain

import com.example.projetotcc.servico.data.remote.ServicoResponse
import com.example.projetotcc.servico.data.repository.ServicoRepository

class ServicoUseCase {

    private val repository by lazy {
        ServicoRepository()
    }

    suspend fun criarServico(
        titulo: String,
        descricao: String?,
        valorServico: Double,
        custoAtual: Double?,
        dataInicio: String,
        enderecoServico: String,
        nome: String,
        telefone: String,
        enderecoCliente: String,
    ): Boolean {
        return repository.criarServico(
            titulo = titulo,
            descricao = descricao,
            valorServico = valorServico,
            custoAtual = custoAtual,
            dataInicio = dataInicio,
            enderecoServico = enderecoServico,
            nome = nome,
            telefone = telefone,
            enderecoCliente = enderecoCliente
        )
    }

    suspend fun buscarTarefaPorIdUsuario(): List<ServicoResponse> {
        return repository.buscarTarefaPorIdUsuario()
    }

    suspend fun buscarTarefasPendentesPorIdUsuario(): List<ServicoResponse> {
        return repository.buscarTarefasPendentesPorIdUsuario()
    }

    suspend fun buscarTarefasPendentesPorIdCliente(idCliente: Int): List<ServicoResponse> {
        return repository.buscarTarefasPendentesPorIdCliente(idCliente)
    }

    suspend fun buscarTarefasConcluidasPorIdUsuario(): List<ServicoResponse> {
        return repository.buscarTarefasConcluidasPorIdUsuario()
    }

    suspend fun buscarTarefasConcluidasPorIdCliente(idCliente: Int): List<ServicoResponse> {
        return repository.buscarTarefasConcluidasPorIdCliente(idCliente)
    }


    suspend fun buscarTarefasPorIdCliente(clienteId: Long): List<ServicoResponse> {
        return repository.buscarTarefasPorIdCliente(clienteId)
    }

    suspend fun deletarServicoPorId(servicoId: Long): Boolean {
        return repository.deletarServicoPorId(servicoId)
    }

    suspend fun finalizarTarefaPorId(tarefaId: Long): Boolean {
        return repository.finalizarTarefaPorId(tarefaId)
    }

    suspend fun adicionarCustoPorIdTarefa(
        tarefaId: Long,
        custoSoma:Double
    ): Boolean {
        return repository.adicionarCustoPorIdTarefa(
            tarefaId,
            custoSoma = custoSoma
        )
    }
}