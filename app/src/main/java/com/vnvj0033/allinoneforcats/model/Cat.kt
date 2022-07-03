package com.vnvj0033.allinoneforcats.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cat(
    val name: String = "",
    val description: String = "",
    val imageUrl: String = "",
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}