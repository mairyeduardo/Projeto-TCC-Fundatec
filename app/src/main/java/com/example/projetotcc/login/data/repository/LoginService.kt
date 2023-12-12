package com.example.projetotcc.login.data.repository

import com.example.projetotcc.login.data.LoginRequest
import com.example.projetotcc.login.data.remote.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @POST("api/v1/usuario/adicionar")
    suspend fun createUser(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @GET("api/v1/usuario/email-e-senha/")
    suspend fun verificarUser(
        @Query("email") email: String,
        @Query("senha") senha: String
    ): Response<LoginResponse>

}
