package com.example.projetotcc.cliente.view

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.cliente.domain.ClienteModel
import com.example.projetotcc.databinding.ActivityClienteDetailsBinding

class ClienteDetailsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityClienteDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClienteDetailsBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        val cliente = intent.extras?.getSerializable("cliente") as? ClienteModel
        if (cliente == null) {
            finish()
            return
        }
        binding.textoNome.text = cliente.nome
        binding.textoTelefone.text = cliente.telefone
        binding.textoEndereco.text = cliente.enderecoPrincipal
        Log.e("teste", cliente.toString())
    }

}