package com.example.projetotcc.home.domain

import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDate

data class ServicoModel(
    val id: Long,
    val titulo: String,
    val descricao: String,
    val valorServico: BigDecimal,
    val custoAtual: BigDecimal,
    val dataInicio: LocalDate,
    val dataFinal: LocalDate?,
    val enderecoServico: String,
    val nomeCliente: String
) : Serializable