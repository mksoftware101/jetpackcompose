package com.dominionsoftware.composesandbox.onboarding

sealed class Screen(val route: String) {
    object AppMain : Screen(route = "app_main_screen")
    object OnboardingMain : Screen(route = "onboarding_main_screen")
//    object OnboardingGetInspired : Screen(route = "onboarding_get_inspired_screen")
//    object OnbaordingEasyAndHealthy : Screen(route = "onboarding_easy_and_healthy_screen")
//    object OnboardingSaveYourFavourities : Screen(route = "onboarding_save_your_favourities_screen")
}