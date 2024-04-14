package com.example.projetotcc.relatorio.domain

import com.example.projetotcc.relatorio.data.remote.RelatorioResponse
import com.example.projetotcc.relatorio.data.repository.RelatorioRepository

class RelatorioUseCase {

    private val repository by lazy {
        RelatorioRepository()
    }

    suspend fun gerarRelatorioPorIdTarefa(idTarefa: Int): RelatorioResponse? {
        return repository.gerarRelatorioPorIdTarefa(idTarefa)
    }

    suspend fun buscarRelatorioPorIdTarefa(idTarefa: Int): RelatorioResponse? {
        return repository.buscarRelatorioPorIdTarefa(idTarefa)
    }
}