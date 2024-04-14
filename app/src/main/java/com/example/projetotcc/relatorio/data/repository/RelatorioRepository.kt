package com.example.projetotcc.relatorio.data.repository

import android.util.Log
import com.example.projetotcc.network.RetrofitNetworkClient
import com.example.projetotcc.relatorio.data.remote.RelatorioResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RelatorioRepository {

    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "http://44.198.225.29:8080/solocraft/"
    ).create(RelatorioService::class.java)

    suspend fun gerarRelatorioPorIdTarefa(idTarefa: Int): RelatorioResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.gerarRelatorioPorIdTarefa(
                    idTarefa
                )
                response.body()
            } catch (ex: Exception) {
                Log.e("gerarRelatorioPorId", ex.message.toString())
                null
            }
        }
    }

    suspend fun buscarRelatorioPorIdTarefa(idTarefa: Int): RelatorioResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.buscarRelatorioPorIdTarefa(
                    idTarefa
                )
                response.body()
            } catch (ex: Exception) {
                Log.e("buscarRelatorioPorId", ex.message.toString())
                null
            }
        }
    }
}