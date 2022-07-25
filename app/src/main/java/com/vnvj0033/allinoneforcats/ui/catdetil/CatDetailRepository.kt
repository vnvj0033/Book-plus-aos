package com.vnvj0033.allinoneforcats.ui.catdetil

import com.vnvj0033.allinoneforcats.App
import com.vnvj0033.allinoneforcats.data.cache.MemoryCache
import com.vnvj0033.allinoneforcats.data.db.CatDatabase
import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.retrofit.RetrofitCore
import com.vnvj0033.allinoneforcats.retrofit.requester.CatRequester
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.lang.Exception

class CatDetailRepository {

    suspend fun loadCatList(name: String): Flow<List<Cat>> = coroutineScope {

        // 메모리 케시에 있는 경우
        if (!MemoryCache.catList[name].isNullOrEmpty()) {
            return@coroutineScope flowOf(MemoryCache.catList[name] ?: ArrayList())
        }

        // 디비에 있는 경우
        val db = CatDatabase.getInstance(App.context)
        val dbCats = db.catDao().getAll()

        if (dbCats.isNotEmpty()) {
            MemoryCache.catList.put(name, dbCats)
            return@coroutineScope flowOf(dbCats)
        }

        // 네트워크 통신
        val result = runCatching {
            val requester = CatRequester.getCatList(name)
            val result = RetrofitCore.catApi.getCatList(requester).execute()
            val body = result.body()

            if (result.isSuccessful && !body.isNullOrEmpty()) {
                body
            } else {
                throw Exception("response is failed")
            }
        }.onSuccess { cats ->
            MemoryCache.catList.put(name, cats)

            cats.forEach { cat->
                MemoryCache.cat.put(cat.name, cat)
                db.catDao().addAll(cat)
            }
        }.getOrNull()

        flowOf(result ?: ArrayList())
    }
}
