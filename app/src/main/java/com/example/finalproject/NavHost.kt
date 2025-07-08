package com.example.finalproject

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.viewmodel.BottomBarViewModel
import com.example.finalproject.viewmodel.JobSharedViewModel
import com.example.finalproject.views.HelpFeedbackScreen
import com.example.finalproject.views.homebottombar.HomeBottomBarScreens
import com.example.finalproject.views.job.ComponyDetails
import com.example.finalproject.views.job.JobDetailsScreen
import com.example.finalproject.views.settings.FAQSScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val sharedJobViewModel: JobSharedViewModel = viewModel()
    val bottomBarViewModel: BottomBarViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = HomeBottomBarScreens.Home.route,
     ) {
        composable(HomeBottomBarScreens.Home.route) {
            HomeBottomBarScreens(
                navController = navController,
                sharedViewModel = sharedJobViewModel,
                bottomBarViewModel = bottomBarViewModel
            )
        }
//        composable(HomeBottomBarScreens.Home.route) { HomeBottomBarScreens(navController, sharedViewModel = sharedJobViewModel) }
        composable(HomeBottomBarScreens.Faqs.route) { FAQSScreen(navController =navController) }
        composable(HomeBottomBarScreens.HelpFeedbackScreen.route) { HelpFeedbackScreen(navController) }
        composable(HomeBottomBarScreens.ComponyDetails.route) { ComponyDetails(sharedJobViewModel,navController) }
        composable(HomeBottomBarScreens.JobsDetails.route) { JobDetailsScreen( sharedViewModel = sharedJobViewModel,navController) }
//        composable(HomeBottomBarScreens.Settings.route) { SettingsScreen() }
    }
}
