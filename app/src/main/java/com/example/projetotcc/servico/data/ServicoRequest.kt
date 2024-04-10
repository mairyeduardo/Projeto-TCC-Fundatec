package com.example.projetotcc.servico.data

import com.squareup.moshi.JsonClass
import java.time.LocalDate

@JsonClass(generateAdapter = true)
class ServicoRequest (
    val idUsuario: Long?,
    val titulo: String?,
    val descricao: String?,
    val valorServico: Double?,
    val custoAtual: Double?,
    val custoSoma: Double?,
    val dataInicio: LocalDate?,
    val enderecoServico: String?,
    cliente: Cliente?
)