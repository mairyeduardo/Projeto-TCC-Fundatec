package com.example.projetotcc.servico.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityDetalhesServicoPendenteBinding

private const val DELAY_TELA = 1000L

class DetalhesServicoPendente : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesServicoPendenteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesServicoPendenteBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

    }
}