package com.example.projetotcc.cliente.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityClienteBinding

class ClienteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClienteBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

    }
}