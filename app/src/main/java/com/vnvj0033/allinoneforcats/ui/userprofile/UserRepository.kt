package com.vnvj0033.allinoneforcats.ui.userprofile

import android.content.Context
import com.vnvj0033.allinoneforcats.App
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.model.User
import kotlinx.coroutines.flow.flowOf

class UserRepository {

    fun loadUser() = flowOf(User(
            name = App.context.getString(R.string.test_text),
            description = App.context.getString(R.string.test_text)
        ))


    fun loadCats() = flowOf(ArrayList<Cat>().apply { for (i in 0..100) add(Cat()) })

}
