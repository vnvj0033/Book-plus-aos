package com.vnvj0033.allinoneforcats.ui.catdetil

import com.vnvj0033.allinoneforcats.App
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.db.CatDatabase
import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.retrofit.RetrofitCore
import com.vnvj0033.allinoneforcats.retrofit.requester.CatRequester
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatDetailRepository {

    fun loadCat(): Flow<Cat> {

        val db = CatDatabase.getInstance(App.context)

        val cat = db.catDao().getCat("")

        if (cat != null) return flowOf(cat)

        val requester = CatRequester.getCat("")
        RetrofitCore.catApi.getCat(requester).enqueue(object : Callback<Cat> {
            override fun onResponse(call: Call<Cat>, response: Response<Cat>) {

            }

            override fun onFailure(call: Call<Cat>, t: Throwable) {

            }
        })

        return flowOf(
            Cat(name = App.context.getString(R.string.test_text), description = App.context.getString(R.string.test_text))
        )
    }
    fun loadCatList(): Flow<List<Cat>> {
        val list = ArrayList<Cat>().apply { for (i in 0..100) add(Cat()) }
        return flowOf(list)
    }
}
