package com.vnvj0033.allinoneforcats.data.cache

import androidx.collection.LruCache
import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.model.User

object MemoryCache {
    val catList = LruCache<String, List<Cat>>(25)
    val cat = LruCache<String, List<Cat>>(1000)
    val user = LruCache<String, User>(15)
}