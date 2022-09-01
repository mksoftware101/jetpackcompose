package com.dominionsoftware.composesandbox.onboarding

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun OnbardingAppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.OnboardingMain.route
    ) {
        composable(route = Screen.OnboardingMain.route) {
            OnboardingMainScreen(navController)
        }
        composable(route = Screen.AppMain.route) {
            AppMainScreen()
        }
    }
}