package com.vnvj0033.allinoneforcats.ui.catdetil

import com.vnvj0033.allinoneforcats.App
import com.vnvj0033.allinoneforcats.data.cache.CatCache
import com.vnvj0033.allinoneforcats.data.db.CatDatabase
import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.retrofit.RetrofitCore
import com.vnvj0033.allinoneforcats.retrofit.requester.CatRequester
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CatDetailRepository {

    suspend fun loadCatList(name: String): Flow<List<Cat>> = coroutineScope {

        // 메모리 케시에 있는 경우
        if (CatCache.catListMap.contains(name)) {
            return@coroutineScope flowOf(CatCache.catListMap[name] ?: ArrayList())
        }

        val db = CatDatabase.getInstance(App.context)
        val cats = db.catDao().getList(name)

        // 디비에 있는 경우
        if (cats.isNotEmpty()) {
            CatCache.catListMap[name] = cats
            return@coroutineScope flowOf(cats)
        }


        val requester = CatRequester.getCatList(name)
        val response = RetrofitCore.catApi.getCatList(requester).execute()

        // 네트워크 통신시
        if (response.isSuccessful) {

            CatCache.catListMap[name] = cats

            response.body()?.forEach { cat->
                db.catDao().addAll(cat)
            }
            return@coroutineScope flowOf(response.body() ?: ArrayList())
        } else {
            val list = ArrayList<Cat>().apply { for (i in 0..100) add(Cat()) }
            return@coroutineScope flowOf(list)
        }
    }
}
