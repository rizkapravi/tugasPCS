package com.example.tokoserbaserbi.ui.resep

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tokoserbaserbi.data.model.ActionState
import com.example.tokoserbaserbi.data.model.Resep
import com.example.tokoserbaserbi.data.repository.ResepRepository
import kotlinx.coroutines.launch

class ResepViewModel : ViewModel() {
    private val repo: ResepRepository by lazy { ResepRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Resep>>()
    val detailResp = MutableLiveData<Resep>()
    val searchResp = MutableLiveData<List<Resep>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listResep() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listResep()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailResep(url: String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailResep(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchResep(query: String? = this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchResep(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}