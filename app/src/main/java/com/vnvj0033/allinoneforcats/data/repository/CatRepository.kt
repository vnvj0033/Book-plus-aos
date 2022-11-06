package com.vnvj0033.allinoneforcats.data.repository

import com.vnvj0033.allinoneforcats.data.entry.CatEntry

interface CatRepository {
    suspend fun getCatList(): List<CatEntry>
}