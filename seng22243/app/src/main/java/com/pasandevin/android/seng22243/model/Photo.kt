//Recycler View, Database//
package com.pasandevin.android.seng22243.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo")
data class Photo (
    @PrimaryKey var id: String,
    var title: String,
    var thumbnailUrl: String,
    var url: String
    )
//Recycler View, Database//