//Recycler View, Database//
package com.pasandevin.android.seng22243.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Metadata(
    var size: String,
    var owner: String
)

@Entity(tableName = "photo")
data class Photo (
    @PrimaryKey var id: String,
    var title: String,
    var thumbnailUrl: String,
    var url: String,
    @Embedded var metadata: Metadata?
    )
//Recycler View, Database//