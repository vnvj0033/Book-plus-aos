package com.vnvj0033.allinoneforcats.domain.model

import android.os.Parcelable
import com.vnvj0033.allinoneforcats.data.entry.CatEntry
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailCat(
    val id: String = "",
    val url: String = ""
) : Parcelable

fun CatEntry.toDetailCat() =
    DetailCat(id, url)