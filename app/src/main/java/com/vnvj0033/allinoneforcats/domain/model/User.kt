package com.vnvj0033.allinoneforcats.domain.model

data class User(
    val name: String = "",
    val profileImageUrl: String = "",
    val description: String = "",
    val follower: Int = 0,
    val following: Int = 0,
    val posts: List<Cat> = ArrayList()
)

