package com.example.projetotcc.servico.view

import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityCustoServicoBinding

private const val DELAY_TELA = 1000L

class AdicionarCustoActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCustoServicoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustoServicoBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

    }

}