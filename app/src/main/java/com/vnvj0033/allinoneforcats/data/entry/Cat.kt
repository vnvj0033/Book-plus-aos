package com.vnvj0033.allinoneforcats.data.entry

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity
data class Cat(
    val id: String = "",
    val url: String = "",
    val width: String = "",
    val height: String = ""
) : Parcelable
