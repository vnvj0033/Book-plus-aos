package com.vnvj0033.bookplus.data.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey


@Keep
@Entity
data class Book(
    @PrimaryKey val id: Int,
    val imgUtl: String = "",
    val title: String = "title",
    val writer: String = "writer",
    val summary: String = "summary",
    val genre: String = "summary",
)