package com.example.projetotcc.database


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.projetotcc.database.converter.Converters
import com.example.projetotcc.login.data.local.UserDao
import com.example.projetotcc.login.data.local.UserEntity
import com.example.projetotcc.App

@Database(entities = [UserEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class FHDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(): FHDatabase {
            return Room.databaseBuilder(
                App.context,
                FHDatabase::class.java,
                "fh.database"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
    }
}