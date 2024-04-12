package com.example.projetotcc.home.domain

import com.example.projetotcc.servico.data.remote.ServicoResponse

fun List<ServicoResponse>.toModel(): List<ServicoModel> {
    return map { servico ->
        ServicoModel(
            id = servico.id,
            idUsuario = servico.idUsuario,
            titulo = servico.titulo,
            descricao = servico.descricao,
            valorServico = servico.valorServico,
            custoAtual = servico.custoAtual,
            custoSoma = servico.custoSoma,
            dataInicio = servico.dataInicio,
            dataFinal = servico.dataFinal,
            enderecoServico = servico.enderecoServico,
            statusTarefa = servico.statusTarefa,
            idCliente = servico.idCliente,
            nomeCliente = servico.nomeCliente
        )
    }
}