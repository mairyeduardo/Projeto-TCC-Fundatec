package com.example.projetotcc.servico.data.remote

import java.math.BigDecimal
import java.time.LocalDate

data class ServicoResponse (
    val id: Long,
    val idUsuario: Long,
    val titulo: String,
    val descricao: String,
    val valorServico: BigDecimal,
    val custoAtual: BigDecimal,
    val custoSoma: BigDecimal?,
    val dataInicio: LocalDate,
    val dataFinal: LocalDate?,
    val enderecoServico: String,
    val statusTarefa: String,
    val idCliente: Long,
    val nomeCliente: String
)