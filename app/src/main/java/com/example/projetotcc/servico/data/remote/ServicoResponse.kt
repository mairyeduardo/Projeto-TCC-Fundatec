package com.example.projetotcc.servico.data.remote

import java.math.BigDecimal
import java.time.LocalDate

data class ServicoResponse (
    val id: Int,
    val idUsuario: Int,
    val titulo: String,
    val descricao: String,
    val valorServico: Double,
    val custoAtual: Double,
    val custoSoma: Double?,
    val dataInicio: String,
    val dataFinal: String?,
    val enderecoServico: String,
    val statusTarefa: String,
    val idCliente: Int,
    val nomeCliente: String
)