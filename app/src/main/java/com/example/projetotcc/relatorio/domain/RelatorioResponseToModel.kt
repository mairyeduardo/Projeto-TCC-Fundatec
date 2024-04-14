package com.example.projetotcc.relatorio.domain

import com.example.projetotcc.relatorio.data.remote.RelatorioResponse

fun RelatorioResponse.toModel(): RelatorioModel {
    return RelatorioModel(
        id = this.id,
        idTarefa = this.idTarefa,
        tituloTarefa = this.tituloTarefa,
        descricaoTarefa = this.descricaoTarefa,
        valorServico = this.valorServico,
        custoAtual = this.custoAtual,
        dataInicio = this.dataInicio,
        dataFinal = this.dataFinal,
        totalDeDias = this.totalDeDias,
        enderecoServico = this.enderecoServico,
        nomeCliente = this.nomeCliente,
        valorLiquido = this.valorLiquido
    )
}