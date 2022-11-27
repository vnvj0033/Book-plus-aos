package com.vnvj0033.bookplus.data.entry

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity
data class CatEntry(
    @PrimaryKey val id: String = "",
    val url: String = "",
    val width: String = "",
    val height: String = ""
)
