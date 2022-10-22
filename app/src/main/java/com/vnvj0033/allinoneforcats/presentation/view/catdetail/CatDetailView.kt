package com.vnvj0033.allinoneforcats.presentation.view.catdetail

import com.vnvj0033.allinoneforcats.domain.model.Cat

interface CatDetailView {

    interface AdapterEvent {
        fun goToCatDetail(cat: Cat)

    }
}
