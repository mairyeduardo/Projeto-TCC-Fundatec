package com.example.projetotcc.login.domain

import com.example.projetotcc.login.data.repository.LoginRepository

class LoginUseCase {
    private val repository by lazy {
        LoginRepository()
    }

    suspend fun createUser(
        nome:String,
        email:String,
        senha:String,
    ):Boolean{
        return repository.createUser(
            nome = nome,
            email = email,
            senha = senha,
        )
    }

    suspend fun verificarUser(
        email: String,
        senha: String,
    ): Boolean {
        return repository.verificarUser(
            email = email,
            senha = senha,
        )
    }

}