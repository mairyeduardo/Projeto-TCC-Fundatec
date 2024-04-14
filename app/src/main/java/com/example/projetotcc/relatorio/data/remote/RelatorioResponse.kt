package com.example.projetotcc.relatorio.data.remote

data class RelatorioResponse (
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
)
