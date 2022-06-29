package com.vnvj0033.allinoneforcats.ui.catdetil

import com.vnvj0033.allinoneforcats.App
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.model.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CatDetailRepository {
    fun loadCat(): Flow<Cat> = flowOf(Cat(name = App.context.getString(R.string.test_text), description = App.context.getString(R.string.test_text)))
}
