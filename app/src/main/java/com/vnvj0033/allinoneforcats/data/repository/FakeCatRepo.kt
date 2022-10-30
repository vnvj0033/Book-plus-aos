package com.vnvj0033.allinoneforcats.data.repository

import com.vnvj0033.allinoneforcats.data.entry.Cat

class FakeCatRepo : CatRepository {
    override suspend fun getCatList(): List<Cat> = ArrayList<Cat>().apply {
        add(Cat(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(Cat(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(Cat(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(Cat(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(Cat(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
    }

}
