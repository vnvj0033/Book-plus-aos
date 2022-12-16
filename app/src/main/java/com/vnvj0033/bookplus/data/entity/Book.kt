package com.vnvj0033.bookplus.data.entity

import androidx.annotation.Keep

@Keep
data class Book(
    val imgUtl: String = "",
    val title: String = "",
    val writer: String = "",
    val summary: String = ""
)