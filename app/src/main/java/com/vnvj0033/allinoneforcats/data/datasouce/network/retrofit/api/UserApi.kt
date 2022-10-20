package com.vnvj0033.allinoneforcats.data.datasouce.network.retrofit.api

import com.vnvj0033.allinoneforcats.domain.model.User
import retrofit2.Call
import retrofit2.http.*

interface UserApi {

    @GET("")
    fun getUser(@QueryMap queryMap: Map<String, String>): Call<User>

    @FormUrlEncoded
    @POST("")
    fun postUser(@FieldMap queryMap: Map<String, String>): Call<Unit>

    @FormUrlEncoded
    @PUT("")
    fun putUser(@FieldMap queryMap: Map<String, String>): Call<Unit>
}