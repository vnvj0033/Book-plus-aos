package com.vnvj0033.allinoneforcats.domain.model

import com.vnvj0033.allinoneforcats.data.entry.CatEntry

data class DetailCat(
    val id: String = "",
    val url: String = ""
)

fun CatEntry.toDetailCat() =
    DetailCat(id, url)