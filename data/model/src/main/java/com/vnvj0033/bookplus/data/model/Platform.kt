package com.vnvj0033.bookplus.data.model

sealed interface Platform {

    companion object {
        fun platforms() = Platform::class.sealedSubclasses.mapNotNull {
            it.objectInstance
        }
    }

    fun name(): String = this.javaClass.simpleName
    val resource: Int

    object KYOBO : Platform {
        override val resource = R.drawable.logo_kyobo

        object `생활` : Genre
        object `국문` : Genre
        object `영문` : Genre
        object `컴퓨터_과학` : Genre
        object `인문학` : Genre
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

    sealed interface Genre {
        fun name(): String = this.javaClass.simpleName
    }
}