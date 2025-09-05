package com.example.starwarspoc.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.starwarspoc.domain.User

@Dao
interface UserDao{

    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user LIMIT 1")
    suspend fun getFirstUser(): User?

}