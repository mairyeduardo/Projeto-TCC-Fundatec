package com.example.projetotcc.relatorio.presentation.model

import com.example.projetotcc.relatorio.domain.RelatorioModel

sealed class RelatorioViewState {

    data class Success(val relatorio: RelatorioModel) : RelatorioViewState()

    object NotFound: RelatorioViewState()

}