package com.vnvj0033.allinoneforcats.data.entry

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity
data class CatEntry(
    @PrimaryKey val id: String = "",
    val url: String = "",
    val width: String = "",
    val height: String = ""
) : Parcelable
