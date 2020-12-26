package com.example.tokoserbaserbi.data.repository

import com.example.tokoserbaserbi.data.model.ActionState
import com.example.tokoserbaserbi.data.model.Resep
import com.example.tokoserbaserbi.data.remote.ResepService
import com.example.tokoserbaserbi.data.remote.RetrofitApi
import retrofit2.await

class ResepRepository {
    private val resepService: ResepService by lazy { RetrofitApi.resepService() }

    suspend fun listResep() : ActionState<List<Resep>> {
        return try {
            val list = resepService.listResep().await()
            ActionState(list.results)
        }catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailResep(url: String) : ActionState<Resep> {
        return try {
            val list = resepService.detailResep(url).await()
            ActionState(list.results.first())
        }catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchResep(query: String) : ActionState<List<Resep>> {
        return try {
            val list = resepService.searchResep(query).await()
            ActionState(list.results)
        }catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}