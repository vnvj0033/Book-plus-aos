package com.example.model

import java.io.Serializable

data class MainBook(
    val imgUrl: String = "",
    val title: String = "",
    val writer: String = "",
    val summery: String = ""
): Serializable

fun Book.toMainBook() = MainBook(imgUtl, title, writer, summary)
