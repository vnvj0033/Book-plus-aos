package com.vnvj0033.allinoneforcats.data.repository

import com.vnvj0033.allinoneforcats.data.entry.Cat

interface CatRepository {
    suspend fun getCatList(): List<Cat>
}