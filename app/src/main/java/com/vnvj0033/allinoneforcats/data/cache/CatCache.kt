package com.vnvj0033.allinoneforcats.data.cache

import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.model.User

object CatCache {
    val catListMap = HashMap<String, List<Cat>>()
    val catMap = HashMap<String, Cat>()
    val userMap = HashMap<String, User>()
}