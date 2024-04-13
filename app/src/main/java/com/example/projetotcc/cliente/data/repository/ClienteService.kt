package com.example.projetotcc.cliente.data.repository

import com.example.projetotcc.cliente.data.remote.ClienteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ClienteService {

    @GET("api/v1/cliente/usuario/{idUsuario}")
    suspend fun buscarClientesPorIdUsuario(
        @Path("idUsuario") idUsuario: Int,
    ): Response<List<ClienteResponse>>

    @GET("api/v1/cliente/{idUsuario}/{nomeCliente}")
    suspend fun buscarClientesPorNomeUtilizandoIdUsuario(
        @Path("idUsuario") idUsuario: Int,
        @Path("nomeCliente") nomeCliente: String,
    ): Response<ClienteResponse>

}