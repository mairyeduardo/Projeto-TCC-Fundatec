package com.example.projetotcc.relatorio.data.repository

import com.example.projetotcc.relatorio.data.remote.RelatorioResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RelatorioService {

    @POST("api/v1/relatorio/{idTarefa}")
    suspend fun gerarRelatorioPorIdTarefa(
        @Path("idTarefa") idTarefa: Int,
    ): Response<RelatorioResponse>

    @GET("api/v1/relatorio/tarefa/{idTarefa}")
    suspend fun buscarRelatorioPorIdTarefa(
        @Path("idTarefa") idTarefa: Int,
    ): Response<RelatorioResponse>

}