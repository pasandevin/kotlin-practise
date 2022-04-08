package com.pasandevin.android.seng22243.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pasandevin.android.seng22243.model.Photo

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photo")
    fun getAll(): List<Photo>

    @Insert
    fun insert(vararg photo: Photo)
}