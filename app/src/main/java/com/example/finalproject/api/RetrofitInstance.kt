package com.example.finalproject.api

import android.content.Context
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import com.ayaenshasy.rarecare.utils.SettingsManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private var retrofit: Retrofit? = null

    fun getInstance(context: Context): ApiService {
        val settingsManager = SettingsManager(context)
        val currentLang = runBlocking { settingsManager.languageFlow.first() }

        val currentLanguage = currentLang // "en" or "ar"
        val baseUrl = "https://fursaty.kicklance.com/${currentLanguage.selectedLangCode}/api/"
Log.e("sssssss",currentLanguage.selectedLangCode)
Log.e("sssssss",currentLanguage.toString())
        if (retrofit == null || retrofit?.baseUrl().toString() != baseUrl) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!.create(ApiService::class.java)
    }
}
