package com.vnvj0033.bookplus.domain.model

import android.os.Parcelable
import com.vnvj0033.bookplus.data.entry.CatEntry
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailCat(
    val id: String = "",
    val url: String = ""
) : Parcelable

fun CatEntry.toDetailCat() =
    DetailCat(id, url)