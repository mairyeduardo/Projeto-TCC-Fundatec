package com.example.projetotcc.home.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityHomeBinding
import com.example.projetotcc.databinding.ActivityLoginBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

    }
}