package com.example.projetotcc.servico.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityNovoServicoBinding

class NovoServicoActivity : AppCompatActivity(){

    private lateinit var binding: ActivityNovoServicoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNovoServicoBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

    }
}