package com.example.projetotcc.login.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val nome: String,
    val email: String,
    val senha: String,
    val date: Date? = null
)