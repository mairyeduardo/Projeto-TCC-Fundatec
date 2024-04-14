package com.example.projetotcc.servico.data.repository

import com.example.projetotcc.servico.data.ServicoRequest
import com.example.projetotcc.servico.data.remote.ServicoResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ServicoService {

    @POST("api/v1/servico")
    suspend fun criarServico(
        @Body servicoRequest: ServicoRequest
    ): Response<ServicoResponse>

    @DELETE("api/v1/servico/{idTarefa}")
    suspend fun deletarServicoPorId(
        @Path("idTarefa") idTarefa: Int,
    ): Response<ServicoResponse>

    @PUT("api/v1/servico/finalizar/{idTarefa}")
    suspend fun finalizarTarefaPorId(
        @Path("idTarefa") idTarefa: Long,
    ): Response<ServicoResponse>

    @PATCH("api/v1/servico/custo/{idTarefa}")
    suspend fun adicionarCustoPorIdTarefa(
        @Path("idTarefa") idTarefa: Long,
        @Body servicoRequest: ServicoRequest
    ): Response<ServicoResponse>

    @GET("api/v1/servico/usuario/{idUsuario}")
    suspend fun buscarTarefasPorIdUsuario(
        @Path("idUsuario") idUsuario: Int,
    ): Response<List<ServicoResponse>>

    @GET("api/v1/servico/pendente/usuario/{idUsuario}")
    suspend fun buscarTarefasPendentesPorIdUsuario(
        @Path("idUsuario") idUsuario: Int,
    ): Response<List<ServicoResponse>>

    @GET("api/v1/servico/concluida/usuario/{idUsuario}")
    suspend fun buscarTarefasConcluidasPorIdUsuario(
        @Path("idUsuario") idUsuario: Int,
    ): Response<List<ServicoResponse>>

    @GET("api/v1/servico/pendente/cliente/{idCliente}")
    suspend fun buscarTarefasPendentesPorIdCliente(
        @Path("idCliente") idCliente: Int,
    ): Response<List<ServicoResponse>>

    @GET("api/v1/servico/concluida/cliente/{idCliente}")
    suspend fun buscarTarefasConcluidasPorIdCliente(
        @Path("idCliente") idCliente: Int,
    ): Response<List<ServicoResponse>>

    @GET("api/v1/servico/cliente/{idCliente}")
    suspend fun buscarTarefasPorIdCliente(
        @Path("idCliente") idCliente: Long,
    ): Response<List<ServicoResponse>>


}