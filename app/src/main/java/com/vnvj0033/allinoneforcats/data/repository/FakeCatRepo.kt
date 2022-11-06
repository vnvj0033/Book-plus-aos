package com.vnvj0033.allinoneforcats.data.repository

import com.vnvj0033.allinoneforcats.data.entry.CatEntry
import javax.inject.Inject

class FakeCatRepo @Inject constructor()  : CatRepository {
    override suspend fun getCatList(): List<CatEntry> = ArrayList<CatEntry>().apply {
        add(CatEntry(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(CatEntry(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(CatEntry(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(CatEntry(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(CatEntry(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
    }

}
