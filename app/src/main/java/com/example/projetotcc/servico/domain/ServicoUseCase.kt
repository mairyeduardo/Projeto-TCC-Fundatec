package com.example.projetotcc.servico.domain

import com.example.projetotcc.servico.data.Cliente
import com.example.projetotcc.servico.data.remote.ServicoResponse
import com.example.projetotcc.servico.data.repository.ServicoRepository
import java.time.LocalDate

class ServicoUseCase {

    private val repository by lazy {
        ServicoRepository()
    }

    suspend fun criarServico(
        idUsuario: Long,
        titulo: String,
        descricao: String?,
        valorServico: Double,
        custoAtual: Double?,
        custoSoma: Double?,
        dataInicio: LocalDate,
        enderecoServico: String,
        cliente: Cliente
    ): Boolean {
        return repository.criarServico(
            idUsuario = idUsuario,
            titulo = titulo,
            descricao = descricao,
            valorServico = valorServico,
            custoAtual = custoAtual,
            custoSoma = custoSoma,
            dataInicio = dataInicio,
            enderecoServico = enderecoServico,
            cliente = cliente
        )
    }

    suspend fun buscarTarefaPorIdUsuario(): List<ServicoResponse> {
        return repository.buscarTarefaPorIdUsuario()
    }

    suspend fun buscarTarefasPendentesPorIdUsuario(): List<ServicoResponse> {
        return repository.buscarTarefasPendentesPorIdUsuario()
    }

    suspend fun buscarTarefasConcluidasPorIdUsuario(): List<ServicoResponse> {
        return repository.buscarTarefasConcluidasPorIdUsuario()
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