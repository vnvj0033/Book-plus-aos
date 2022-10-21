package com.vnvj0033.allinoneforcats.presentation.view.userprofile

import com.vnvj0033.allinoneforcats.domain.model.Cat

interface UserProfileView{

    interface AdapterEvent {
        fun goToCatDetail(cat: Cat)
    }
}