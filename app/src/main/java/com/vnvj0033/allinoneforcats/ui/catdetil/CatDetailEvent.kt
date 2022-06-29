package com.vnvj0033.allinoneforcats.ui.catdetil

import com.vnvj0033.allinoneforcats.model.Cat

interface CatDetailEvent {
     fun updateCat(cat: Cat)
     fun loadList()
}
