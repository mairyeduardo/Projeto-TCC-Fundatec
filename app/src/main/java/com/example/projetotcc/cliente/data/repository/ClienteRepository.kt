package com.example.projetotcc.cliente.data.repository

import android.util.Log
import com.example.projetotcc.cliente.data.remote.ClienteResponse
import com.example.projetotcc.login.data.repository.LoginRepository
import com.example.projetotcc.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ClienteRepository {

    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "http://44.198.225.29:8080/solocraft/"
    ).create(ClienteService::class.java)

    private val loginRepository: LoginRepository by lazy {
        LoginRepository()
    }

    suspend fun buscarClientesPorIdUsuario(): List<ClienteResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.buscarClientesPorIdUsuario(
                    idUsuario = loginRepository.pegarId()
                )
                response.body()?: listOf()
            } catch (ex: Exception) {
                Log.e("ListaDeClientes", ex.message.toString())
                listOf()
            }
        }
    }

    suspend fun buscarClientesPorNomeUtilizandoIdUsuario(nomeCliente: String): ClienteResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.buscarClientesPorNomeUtilizandoIdUsuario(
                    idUsuario = loginRepository.pegarId(),
                    nomeCliente
                )
                response.body()
            } catch (ex: Exception) {
                Log.e("ListarClientePorNome", ex.message.toString())
                null
            }
        }
    }

}