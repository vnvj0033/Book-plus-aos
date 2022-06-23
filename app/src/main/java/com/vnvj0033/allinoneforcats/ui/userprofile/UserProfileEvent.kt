package com.vnvj0033.allinoneforcats.ui.userprofile

import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.model.User

interface UserProfileEvent{
    fun goToCatDetail(cat: Cat)
    fun updateUser(user: User)
}