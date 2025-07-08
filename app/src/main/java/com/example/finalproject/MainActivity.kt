package com.example.finalproject

import android.content.Context
import android.icu.util.ULocale.getLanguage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import com.ayaenshasy.rarecare.utils.LanguageHelper
import com.ayaenshasy.rarecare.utils.SettingsManager
import com.example.finalproject.ui.theme.FinalProjectTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun attachBaseContext(newBase: Context) {
        val settingsManager = SettingsManager(newBase)
        val currentLang = runBlocking { settingsManager.languageFlow.first() }
        val updatedContext = LanguageHelper.changeLanguage(newBase, currentLang.selectedLangCode)
        super.attachBaseContext(updatedContext)
    }

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WindowCompat.setDecorFitsSystemWindows(window,false)
            val controller = WindowInsetsControllerCompat(window,window.decorView)
            window.navigationBarColor= getColor(R.color.app_color)
            controller.isAppearanceLightNavigationBars=false
            FinalProjectTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FinalProjectTheme {
        Greeting("Android")
    }
}