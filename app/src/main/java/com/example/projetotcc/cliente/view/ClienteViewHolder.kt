package com.example.projetotcc.cliente.view

import androidx.recyclerview.widget.RecyclerView
import com.example.projetotcc.cliente.domain.ClienteModel
import com.example.projetotcc.databinding.ClienteListagemBinding

class ClienteViewHolder(
    private val binding: ClienteListagemBinding,
    private val click: (ClienteModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(cliente: ClienteModel) {
        binding.variavelNome.text = cliente.nome
        binding.variavelLocal.text = cliente.enderecoPrincipal
        binding.variavelTelefone.text = cliente.telefone

        binding.cardRelative.setOnClickListener {
            click(cliente)
        }
    }

}