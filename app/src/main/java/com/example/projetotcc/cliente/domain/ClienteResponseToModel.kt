package com.example.projetotcc.cliente.domain

import com.example.projetotcc.cliente.data.remote.ClienteResponse

fun List<ClienteResponse>.toModel(): List<ClienteModel> {
    return map { cliente ->
        ClienteModel(
            id = cliente.id,
            idUsuario = cliente.idUsuario,
            nome = cliente.nome,
            telefone = cliente.telefone,
            enderecoPrincipal = cliente.enderecoPrincipal,
        )
    }
}