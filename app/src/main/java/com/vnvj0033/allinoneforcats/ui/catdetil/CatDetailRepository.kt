package com.vnvj0033.allinoneforcats.ui.catdetil

import com.vnvj0033.allinoneforcats.App
import com.vnvj0033.allinoneforcats.db.CatDatabase
import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.retrofit.RetrofitCore
import com.vnvj0033.allinoneforcats.retrofit.requester.CatRequester
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CatDetailRepository {

    suspend fun loadCatList(name: String): Flow<List<Cat>> = coroutineScope {

        val db = CatDatabase.getInstance(App.context)

        val cats = db.catDao().getList(name)

        if (cats.isNotEmpty()) {
            return@coroutineScope flowOf(cats)
        }


        val requester = CatRequester.getCatList(name)
        val response = RetrofitCore.catApi.getCatList(requester).execute()

        if (response.isSuccessful) {
            return@coroutineScope flowOf(response.body() ?: ArrayList())
        } else {
            val list = ArrayList<Cat>().apply { for (i in 0..100) add(Cat()) }
            return@coroutineScope flowOf(list)
        }
    }
}
