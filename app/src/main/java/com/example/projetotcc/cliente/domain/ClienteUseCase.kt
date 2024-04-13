package com.example.projetotcc.cliente.domain

import com.example.projetotcc.cliente.data.remote.ClienteResponse
import com.example.projetotcc.cliente.data.repository.ClienteRepository

class ClienteUseCase {

    private val repository by lazy {
        ClienteRepository()
    }

    suspend fun buscarClientesPorIdUsuario(): List<ClienteResponse> {
        return repository.buscarClientesPorIdUsuario()
    }

    suspend fun buscarClientesPorNomeUtilizandoIdUsuario(nomeCliente: String): ClienteResponse? {
        return repository.buscarClientesPorNomeUtilizandoIdUsuario(nomeCliente)
    }
}