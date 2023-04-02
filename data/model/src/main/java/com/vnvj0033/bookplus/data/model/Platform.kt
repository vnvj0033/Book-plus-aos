package com.vnvj0033.bookplus.data.model

interface Platform {
    fun name(): String = this.javaClass.simpleName
    val resource: Int

    object KYOBO : Platform {
        override val resource = R.drawable.logo_kyobo

        object kyobo1 : Genre
        object kyobo2 : Genre
        object kyobo3 : Genre
        object kyobo4 : Genre
        object kyobo5 : Genre
    }

    object YES24 : Platform {
        override val resource = R.drawable.logo_yes24

        object yes24a : Genre
        object yes24b : Genre
        object yes24c : Genre
        object yes24d : Genre
        object yes24e : Genre
    }

    object ALADIN : Platform {
        override val resource = R.drawable.logo_aladin

        object aladin1 : Genre
        object aladin2 : Genre
        object aladin3 : Genre
        object aladin4 : Genre
        object aladin5 : Genre
    }

    interface Genre {
        fun name(): String = this.javaClass.simpleName
    }
}