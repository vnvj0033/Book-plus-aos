package com.vnvj0033.bookplus.data.repository

import com.vnvj0033.bookplus.data.entry.CatEntry

interface CatRepository {
    suspend fun getCatList(): List<CatEntry>
}