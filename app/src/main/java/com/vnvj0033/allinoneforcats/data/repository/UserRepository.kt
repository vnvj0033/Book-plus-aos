package com.vnvj0033.allinoneforcats.data.repository

import android.content.Context
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.domain.model.Cat
import com.vnvj0033.allinoneforcats.domain.model.User
import kotlinx.coroutines.flow.flowOf

class UserRepository(private val context: Context) {

    fun loadUser(cats: List<Cat> = ArrayList()) = flowOf(
        User(
            name = context.getString(R.string.test_text),
            description = context.getString(R.string.test_text),
            posts = cats
        )
    )

}
