package com.example.projetotcc.cliente.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetotcc.cliente.domain.ClienteModel
import com.example.projetotcc.databinding.ClienteListagemBinding

class ClienteListAdapter (
    private val click: (ClienteModel) -> Unit
) : RecyclerView.Adapter<ClienteViewHolder>() {
    private val list: MutableList<ClienteModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
        val binding = ClienteListagemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ClienteViewHolder(binding, click)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addList(items: List<ClienteModel>) {
        list.addAll(items)
        notifyDataSetChanged()
    }
}