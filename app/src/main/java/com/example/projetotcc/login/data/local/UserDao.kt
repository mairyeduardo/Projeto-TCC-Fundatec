package com.example.projetotcc.login.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.Date

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userEntity: UserEntity)

    @Query("SELECT date FROM user_table")
    fun getUserDate(): Date?

    @Query("DELETE FROM user_table")
    fun clearCache()

    @Query("SELECT id FROM user_table LIMIT 1")
    fun pegarId(): Int
}