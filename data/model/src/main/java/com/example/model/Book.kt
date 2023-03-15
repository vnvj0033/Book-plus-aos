package com.example.model

import androidx.annotation.Keep

@Keep
data class Book(
    val imgUtl: String = "",
    val title: String = "title",
    val writer: String = "writer",
    val summary: String = "summary"
)