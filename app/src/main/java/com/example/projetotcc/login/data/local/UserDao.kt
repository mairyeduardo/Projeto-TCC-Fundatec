package com.example.projetotcc.login.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.Date

@Dao
interface UserDao {
    @Insert
    fun insertUser(userEntity: UserEntity)

    @Query("DELETE FROM user_table")
    fun clearCache()

    @Query("SELECT id FROM user_table LIMIT 1")
    fun pegarId(): Int
}