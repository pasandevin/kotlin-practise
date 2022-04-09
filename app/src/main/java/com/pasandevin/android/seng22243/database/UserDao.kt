package com.pasandevin.android.seng22243.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pasandevin.android.seng22243.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insertAll(vararg users: User)
}