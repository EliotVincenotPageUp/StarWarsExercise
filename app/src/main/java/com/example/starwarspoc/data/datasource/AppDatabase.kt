package com.example.starwarspoc.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.starwarspoc.data.datasource.local.dao.UserDao
import com.example.starwarspoc.domain.User


@Database(
    entities = [User::class],
    version = 1,
    exportSchema = true,
    autoMigrations = [
    ]
)

internal abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

internal var database : AppDatabase? = null
fun initializeDatabase(context: Context){

    database = Room.databaseBuilder(context, AppDatabase::class.java, "inventory")
        .fallbackToDestructiveMigration(true) // If migrations needed delete all data and clear schema
        .build()
}