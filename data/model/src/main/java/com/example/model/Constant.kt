package com.example.model

object Constant {
    object Platform {
        val KYOBO = "KYOBO"
        val YES24 = "YES24"
        val ALADIN = "ALADIN"

        fun loadItems() = listOf(
            KYOBO, YES24, ALADIN
        )
    }

    object Genre {
        const val kyobo1 = "kyobo1"
        const val kyobo2 = "kyobo2"
        const val kyobo3 = "kyobo3"
        const val kyobo4 = "kyobo4"
        const val kyobo5 = "kyobo5"

        const val yes24a = "yes24a"
        const val yes24b = "yes24b"
        const val yes24c = "yes24c"
        const val yes24d = "yes24d"
        const val yes24e = "yes24e"

        const val aladin1 = "aladin1"
        const val aladin2 = "aladin2"
        const val aladin3 = "aladin3"
        const val aladin4 = "aladin4"
        const val aladin5 = "aladin5"
    }

}