package com.example.projetotcc.relatorio.domain

import java.io.Serializable

data class RelatorioModel (
    val id: Int,
    val idTarefa: Int,
    val tituloTarefa: String,
    val descricaoTarefa: String,
    val valorServico: Double,
    val custoAtual: Double,
    val dataInicio: String,
    val dataFinal: String,
    val totalDeDias: Int,
    val enderecoServico: String,
    val nomeCliente: String,
    val valorLiquido: Double
) : Serializable
