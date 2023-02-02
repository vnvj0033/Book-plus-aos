package com.vnvj0033.bookplus.data.datasouce

class GenreDatasource {
    var genres = emptyList<String>()

    fun updateGenre(platform: String) {
        genres = if (platform == "kyobo") {
            listOf("kyobo", "kyobo2", "kyobo3", "kyobo4", "kyobo5", "kyobo6", "kyobo7", "kyobo8")
        } else if (platform == "yes24") {
            listOf("yes24a", "yes24b", "yes24c", "yes24d", "yes24e", "yes24f", "yes24g", "yes24h")
        } else if (platform == "aladin") {
            listOf("aladin1", "aladin2", "aladin3", "aladin4", "aladin5", "aladin6", "aladin7", "aladin8")
        } else {
            listOf("1", "2", "3", "4", "5", "6", "7", "8")
        }
    }

}