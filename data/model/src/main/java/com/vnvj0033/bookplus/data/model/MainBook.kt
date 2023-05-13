package com.vnvj0033.bookplus.data.model

import java.io.Serializable

data class MainBook(
    val imgUrl: String = "",
    val title: String = "",
    val writer: String = "",
    val summery: String = ""
): Serializable

fun Book.toMainBook() = MainBook(imgUrl, title, writer, summary)
