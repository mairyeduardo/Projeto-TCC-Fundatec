package com.example.projetotcc.home.domain

import com.example.projetotcc.servico.data.remote.ServicoResponse

fun List<ServicoResponse>.toModel(): List<ServicoModel> {
    return map { servico ->
        ServicoModel(
            id = servico.id,
            titulo = servico.titulo,
            descricao = servico.descricao,
            valorServico = servico.valorServico,
            custoAtual = servico.custoAtual,
            dataInicio = servico.dataInicio,
            dataFinal = servico.dataFinal,
            enderecoServico = servico.enderecoServico,
            nomeCliente = servico.nomeCliente
        )
    }
}