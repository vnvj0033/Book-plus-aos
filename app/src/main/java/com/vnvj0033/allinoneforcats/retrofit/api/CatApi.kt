package com.vnvj0033.allinoneforcats.retrofit.api

import com.vnvj0033.allinoneforcats.model.Cat
import retrofit2.Call
import retrofit2.http.*

interface CatApi {

    @GET("")
    fun getCat(@QueryMap queryMap: Map<String, String>): Call<Cat>

    @FormUrlEncoded
    @POST("")
    fun postCat(@FieldMap queryMap: Map<String, String>): Call<Unit>

    @FormUrlEncoded
    @PUT("")
    fun putCat(@FieldMap queryMap: Map<String, String>): Call<Unit>
}