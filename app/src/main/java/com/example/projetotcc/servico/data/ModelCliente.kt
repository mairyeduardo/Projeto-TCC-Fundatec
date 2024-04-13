package com.example.projetotcc.servico.data


data class ModelCliente (
    val cliente: Cliente
)

data class Cliente(
    val nome:String,
    val telefone:String,
    val enderecoPrincipal:String
)
