package com.example.finalproject.views.settings

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.ayaenshasy.rarecare.utils.AppLanguage
import com.ayaenshasy.rarecare.utils.SettingsManager
import com.example.finalproject.HomeBottomBarScreens
import com.example.finalproject.R
import com.example.finalproject.items.RowItem
import com.example.finalproject.items.TextItem
import com.example.finalproject.items.bottomsheets.LanguageSelectionContent
import com.example.finalproject.items.bottomsheets.NotificationItem
import com.example.finalproject.items.bottomsheets.PolicyBottomSheet
import com.example.finalproject.model.SettingsModelClass
import com.example.finalproject.model.faqs.FaqsData
import com.example.finalproject.model.policies.Data
import com.example.finalproject.viewmodel.PoliciesViewModel
import kotlinx.coroutines.launch
import java.util.Locale

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavHostController) {
    val sheetState = rememberModalBottomSheetState()
    val languageSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val notificationSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

     val settingsManager = remember { SettingsManager(context) }
    val currentLang by settingsManager.languageFlow.collectAsState(initial = AppLanguage("English", "en"))
    var showLanguageSheet by remember { mutableStateOf(false) }
    var showNotificationSheet by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {

            // Header
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextItem(
                    stringResource(R.string.settings),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = colorResource(R.color.app_color),
                        fontWeight = FontWeight.Bold
                    )
                )
                Icon(
                    painter = painterResource(R.drawable.icon_notification),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }

            Spacer(Modifier.height(24.dp))

            TextItem("General Settings", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
            Spacer(Modifier.height(16.dp))

            val settings = listOf(
                SettingsModelClass(painterResource(R.drawable.icon_feather_flag), stringResource(R.string.job_preference_country), painterResource(R.drawable.baseline_keyboard_arrow_right_24), key = "job_pref"),
                SettingsModelClass(painterResource(R.drawable.faqs), stringResource(R.string.faqs), painterResource(R.drawable.baseline_keyboard_arrow_right_24), key = "faqs"),
                SettingsModelClass(painterResource(R.drawable.help),
                    stringResource(R.string.help_feedback), painterResource(R.drawable.baseline_keyboard_arrow_right_24), key = "help"),
                SettingsModelClass(painterResource(R.drawable.privacy),
                    stringResource(R.string.privacy_policy), painterResource(R.drawable.baseline_keyboard_arrow_right_24), key = "privacy"),
                SettingsModelClass(painterResource(R.drawable.language), stringResource(R.string.language_preference), painterResource(R.drawable.baseline_keyboard_arrow_right_24), key = "language"),
                SettingsModelClass(painterResource(R.drawable.notification), stringResource(R.string.notification_settings), painterResource(R.drawable.baseline_keyboard_arrow_right_24), key = "notification"),
            )

            LazyColumn(Modifier.fillMaxSize()) {
                items(settings) { list ->
                    RowItem(list, true, onClick = {
                        when (list.key) {
                            "privacy" -> scope.launch { sheetState.show() }
                            "notification" -> scope.launch { notificationSheetState.show() }
                            "faqs" -> navController.navigate(HomeBottomBarScreens.Faqs.route)
                            "help" -> navController.navigate(HomeBottomBarScreens.HelpFeedbackScreen.route)
                            "language" -> showLanguageSheet = true
                        }
                    })
                }
            }
        }

        // Policy Sheet
        if (sheetState.isVisible) {
            ModalBottomSheet(
                onDismissRequest = { scope.launch { sheetState.hide() } },
                sheetState = sheetState,
                containerColor = Color.White
            ) {
                PolicyBottomSheet()
            }
        }

        // Language Bottom Sheet
        if (showLanguageSheet) {
            ModalBottomSheet(
                onDismissRequest = { showLanguageSheet = false },
                sheetState = languageSheetState,
                containerColor = Color.White,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            ) {
                LanguageSelectionContent(
                    selected = currentLang.selectedLangCode,
                    onSelect = { langCode ->
                        showLanguageSheet = false

                        scope.launch {
                            // حفظ اللغة الجديدة
                            val lang = if (langCode == "ar") AppLanguage(
                                "ar",
                                "ar"
                            ) else AppLanguage("English", "en")
                            settingsManager.saveSelectedLanguage(lang)

                            // تغيير اللغة وتحديث التطبيق
                            val activity = context as? Activity

                            (activity as? Activity)?.let {
                                val intent = it.intent
                                it.finish()
                                it.startActivity(intent)
                            }
                        }
                    }
                )
            }
        }

        if (notificationSheetState.isVisible) {
            ModalBottomSheet(
                onDismissRequest = { scope.launch { notificationSheetState.hide() } },
                sheetState = notificationSheetState,
                containerColor = Color.White,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            ) {
                NotificationItem()
            }
        }
    }
}



