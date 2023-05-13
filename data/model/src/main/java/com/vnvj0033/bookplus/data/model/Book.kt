package com.vnvj0033.bookplus.data.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Keep
@Entity
data class Book(
    @PrimaryKey val id: Int,
    @SerializedName("rank") val rank: Int,
    @SerializedName("imageUrl") val imgUrl: String = "",
    @SerializedName("title") val title: String = "title",
    @SerializedName("wirter") val writer: String = "writer",
    val summary: String = "summary",
    val genre: String = "genre",
)