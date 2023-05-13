package com.vnvj0033.bookplus.data.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Keep
@Entity
data class Book(
    @PrimaryKey val id: Int,
    @SerializedName("rank") val rank: Int = -1,
    @SerializedName("image_url") val imgUrl: String = "image_url",
    @SerializedName("title") val title: String = "title",
    @SerializedName("writer") val writer: String = "writer",
    @SerializedName("summary") val summary: String = "summary",
    @SerializedName("genre") val genre: String = "genre",
)