package com.vnvj0033.allinoneforcats.presentation.view.userprofile

import com.vnvj0033.allinoneforcats.domain.model.Cat
import com.vnvj0033.allinoneforcats.domain.model.User

interface UserProfileEvent{
    fun goToCatDetail(cat: Cat)
    fun updateUser(user: User)
    fun updateCatList(cats: List<Cat>)
}