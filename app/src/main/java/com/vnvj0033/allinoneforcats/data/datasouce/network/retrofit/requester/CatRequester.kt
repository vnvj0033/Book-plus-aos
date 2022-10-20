package com.vnvj0033.allinoneforcats.data.datasouce.network.retrofit.requester

import com.vnvj0033.allinoneforcats.domain.model.Cat

object CatRequester {

    fun getCat(name: String): Map<String, String> =
        HashMap<String, String>().apply {
            put("name", name)
        }

    fun getCatList(name: String): Map<String, String> =
        HashMap<String, String>().apply {
            put("name", name)
        }

    fun postCat(cat: Cat): Map<String, String> =
        HashMap<String, String>().apply {
            put("name", cat.name)
            put("description", cat.description)
            put("image_url", cat.imageUrl)
        }

    fun putCat(catName: String, name: String? = null, description: String? = null, imageUrl: String? = null): Map<String, String> =
        HashMap<String, String>().apply {
            put("cat_name", catName)
            name?.let { put("name", it) }
            description?.let { put("description", it) }
            imageUrl?.let { put("imageUrl", it) }
        }
}