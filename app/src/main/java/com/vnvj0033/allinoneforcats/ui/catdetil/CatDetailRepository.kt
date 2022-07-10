package com.vnvj0033.allinoneforcats.ui.catdetil

import com.vnvj0033.allinoneforcats.App
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.db.CatDatabase
import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.retrofit.RetrofitCore
import com.vnvj0033.allinoneforcats.retrofit.requester.CatRequester
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CatDetailRepository {

    suspend fun loadCat(): Flow<Cat> = coroutineScope {
        val db = CatDatabase.getInstance(App.context)

        val cat = db.catDao().getCat("")

        db.close()

        if (cat != null) return@coroutineScope flowOf(cat)

        val requester = CatRequester.getCat("")
        val response = RetrofitCore.catApi.getCat(requester).execute()

        if (response.isSuccessful) {
            return@coroutineScope flowOf(response.body() ?: Cat())
        } else {
            return@coroutineScope flowOf(
                Cat(name = App.context.getString(R.string.test_text), description = App.context.getString(R.string.test_text))
            )
        }
    }

    fun loadCatList(): Flow<List<Cat>> {
        val list = ArrayList<Cat>().apply { for (i in 0..100) add(Cat()) }
        return flowOf(list)
    }
}
