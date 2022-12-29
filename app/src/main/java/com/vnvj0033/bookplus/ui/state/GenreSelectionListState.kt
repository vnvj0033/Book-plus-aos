package com.vnvj0033.bookplus.ui.state

data class GenreSelectionListState(
    val options: List<String> = listOf(),
    var selectGenre: String = ""
)
