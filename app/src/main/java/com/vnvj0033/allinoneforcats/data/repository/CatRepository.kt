package com.vnvj0033.allinoneforcats.data.repository

import com.vnvj0033.allinoneforcats.domain.model.DetailCat

interface CatRepository {
    suspend fun getCatList(): List<DetailCat>
}