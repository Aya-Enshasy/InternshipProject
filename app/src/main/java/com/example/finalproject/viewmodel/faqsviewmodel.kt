package com.example.finalproject.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.api.RetrofitInstance
import com.example.finalproject.model.faqs.FaqsData
import kotlinx.coroutines.launch

class FaqsViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application.applicationContext
    private val api = RetrofitInstance.getInstance(context)

    var items by mutableStateOf<List<FaqsData>>(emptyList())
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
                val response = api.getFaqs()
                if (response.isSuccessful) {
                    items = response.body()?.data ?: emptyList()
                } else {
                    errorMessage = "خطأ في الاتصال: ${response.code()}"
                }
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }
}
