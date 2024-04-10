package com.example.projetotcc.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetotcc.databinding.HomeServiceListBinding
import com.example.projetotcc.home.domain.ServicoModel

class ServicoListAdapter(
    private val click: (ServicoModel) -> Unit
) : RecyclerView.Adapter<ServicoViewHolder>() {
    private val list: MutableList<ServicoModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicoViewHolder {
        val binding = HomeServiceListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ServicoViewHolder(binding, click)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ServicoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addList(items: List<ServicoModel>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun retrieveCharacter(position: Int): ServicoModel {
        return list[position]
    }
}