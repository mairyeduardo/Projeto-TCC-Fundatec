package com.example.projetotcc.login.data.repository

import android.util.Log
import com.example.projetotcc.database.FHDatabase
import com.example.projetotcc.login.data.LoginRequest
import com.example.projetotcc.login.data.local.UserEntity
import com.example.projetotcc.login.data.remote.LoginResponse
import com.example.projetotcc.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository {
    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "http://3.237.94.2:8081/solocraft/"
    ).create(LoginService::class.java)

    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }

    suspend fun createUser(nome: String, email: String, senha: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.createUser(
                    loginRequest = LoginRequest(
                        nome = nome,
                        email = email,
                        senha = senha
                    )
                )
                response.isSuccessful
            } catch (ex: Exception) {
                Log.e("createUser", ex.message.toString())
                false
            }
        }
    }

    suspend fun verificarUser( email: String, senha: String): Boolean{
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.verificarUser(
                    email = email,
                    senha = senha,
                )
                response.isSuccessful
            } catch (ex: java.lang.Exception) {
                Log.e("verificarUser", ex.message.toString())
                false
            }
        }
    }

    suspend fun clearDateCache() {
        return withContext(Dispatchers.IO) {
            database.userDao().clearCache()
        }
    }

    suspend fun pegarId(): Int {
        return withContext(Dispatchers.IO) {
            database.userDao().pegarId()
        }
    }

}