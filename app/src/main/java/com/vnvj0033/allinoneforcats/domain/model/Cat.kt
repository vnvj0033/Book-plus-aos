package com.vnvj0033.allinoneforcats.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Cat(
    val name: String = "",
    val description: String = "",
    val imageUrl: String = "",
): Parcelable {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}