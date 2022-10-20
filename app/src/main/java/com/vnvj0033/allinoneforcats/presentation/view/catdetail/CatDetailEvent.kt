package com.vnvj0033.allinoneforcats.presentation.view.catdetail

import com.vnvj0033.allinoneforcats.domain.model.Cat

interface CatDetailEvent {
    fun updateCat(cat: Cat)
    fun updateList(list: List<Cat>)
    fun goToCatDetail(cat: Cat)
}
