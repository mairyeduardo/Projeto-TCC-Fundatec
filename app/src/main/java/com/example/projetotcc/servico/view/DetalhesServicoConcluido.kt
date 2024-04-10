package com.example.projetotcc.servico.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityDetalhesServicoConcluidoBinding


private const val DELAY_TELA = 1000L

class DetalhesServicoConcluido : AppCompatActivity(){

    private lateinit var binding: ActivityDetalhesServicoConcluidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesServicoConcluidoBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

    }

}