package com.example.tokoserbaserbi.data.remote

import com.example.tokoserbaserbi.data.model.ResepList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ResepService {

    @GET("api/recipes")
    fun listResep() : Call<ResepList>

    @GET("detail")
    fun detailResep(@Query("url") url: String) : Call<ResepList>

    @GET("search")
    fun searchResep(@Query("q") query: String) : Call<ResepList>
}