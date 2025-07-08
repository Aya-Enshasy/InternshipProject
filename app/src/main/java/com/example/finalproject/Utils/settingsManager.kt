package com.ayaenshasy.rarecare.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

 val Context.datastore by preferencesDataStore(name = "app_settings")

data class AppLanguage(val selectedLang: String, val selectedLangCode: String)

class SettingsManager(private val context: Context) {

    companion object {
        private val SELECTED_LANGUAGE = stringPreferencesKey("selected_language")
        private val SELECTED_LANGUAGE_CODE = stringPreferencesKey("selected_language_code")
    }

    val languageFlow: Flow<AppLanguage> = context.datastore.data.map { preferences ->
        AppLanguage(
            selectedLang = preferences[SELECTED_LANGUAGE] ?: "English",
            selectedLangCode = preferences[SELECTED_LANGUAGE_CODE] ?: "en"
        )
    }

    suspend fun saveSelectedLanguage(appLanguage: AppLanguage) {
        context.datastore.edit { preferences ->
            preferences[SELECTED_LANGUAGE] = appLanguage.selectedLang
            preferences[SELECTED_LANGUAGE_CODE] = appLanguage.selectedLangCode
        }
    }
}
