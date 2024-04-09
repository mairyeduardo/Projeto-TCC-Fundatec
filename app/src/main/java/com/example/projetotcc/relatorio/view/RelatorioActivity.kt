package com.example.projetotcc.relatorio.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityRelatorioBinding

class RelatorioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRelatorioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRelatorioBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

    }
}