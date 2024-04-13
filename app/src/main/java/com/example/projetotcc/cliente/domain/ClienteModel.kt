package com.example.projetotcc.cliente.domain

import java.io.Serializable

data class ClienteModel (
    val id: Int,
    val idUsuario: Int,
    val nome: String,
    val telefone: String,
    val enderecoPrincipal: String
) : Serializable