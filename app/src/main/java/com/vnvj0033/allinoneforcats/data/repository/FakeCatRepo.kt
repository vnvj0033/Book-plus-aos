package com.vnvj0033.allinoneforcats.data.repository

import com.vnvj0033.allinoneforcats.domain.model.DetailCat
import javax.inject.Inject

class FakeCatRepo @Inject constructor()  : CatRepository {
    override suspend fun getCatList(): List<DetailCat> = ArrayList<DetailCat>().apply {
        add(DetailCat(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(DetailCat(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(DetailCat(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(DetailCat(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
        add(DetailCat(url = "https://cdn2.thecatapi.com/images/a7g.jpg"))
    }

}
