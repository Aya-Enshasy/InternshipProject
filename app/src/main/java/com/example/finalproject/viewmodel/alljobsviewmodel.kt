package com.example.finalproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.api.RetrofitInstance
 import com.example.finalproject.model.alljobs.AllJobsData
import com.example.finalproject.model.alljobs.Skill
import kotlinx.coroutines.launch

class AllJobsViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application.applicationContext
    private val api = RetrofitInstance.getInstance(context)

    var items by mutableStateOf<List<AllJobsData>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        fetchItems()
    }

    fun fetchItems() {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = api.getAllJobs()
                if (response.isSuccessful) {
                    Log.e("kkkkkk",response.body()?.data.toString())
                    items = response.body()?.data ?: emptyList()
                } else {

                    errorMessage = "خطأ في الاتصال: ${response.code()}"
                    Log.e("eeeeeeeeeeee",errorMessage.toString())
                    Log.e("eeeeeeeeeeee",response.message().toString())
                }
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }
}
