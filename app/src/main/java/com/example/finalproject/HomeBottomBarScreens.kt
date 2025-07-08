package com.example.finalproject

sealed class HomeBottomBarScreens(val route: String) {
    object Home: HomeBottomBarScreens("home")
    object Faqs : HomeBottomBarScreens("faqs")
    object JobsDetails : HomeBottomBarScreens("jobsDetails")
    object Settings : HomeBottomBarScreens("settings")
    object HelpFeedbackScreen : HomeBottomBarScreens("helpFeedbackScreen")
    object ComponyDetails : HomeBottomBarScreens("componyDetails")
}