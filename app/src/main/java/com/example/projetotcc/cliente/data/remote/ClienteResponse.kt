package com.example.projetotcc.cliente.data.remote

data class ClienteResponse (
    val id: Int,
    val idUsuario: Int,
    val nome: String,
    val telefone: String,
    val enderecoPrincipal: String
)
