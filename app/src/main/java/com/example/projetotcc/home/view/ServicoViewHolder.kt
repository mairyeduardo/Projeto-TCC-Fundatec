package com.example.projetotcc.home.view

import androidx.recyclerview.widget.RecyclerView
import com.example.projetotcc.databinding.HomeServiceListBinding
import com.example.projetotcc.home.domain.ServicoModel

class ServicoViewHolder(
    private val binding: HomeServiceListBinding,
    private val click: (ServicoModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(servico: ServicoModel) {
        binding.tituloServicso.text = servico.titulo

        binding.cardRelative.setOnClickListener {
            click(servico)
        }

    }

}