package com.vnvj0033.bookplus.domain.model

import java.io.Serializable

data class MainBook(
    val imgUrl: String,
    val title: String,
    val writer: String,
    val summery: String
): Serializable
