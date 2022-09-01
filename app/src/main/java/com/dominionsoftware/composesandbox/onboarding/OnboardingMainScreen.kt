package com.dominionsoftware.composesandbox.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingMainScreen(navController: NavController? = null) {
    val pagerState = rememberPagerState()
    val navigateToAppMain = { navController?.navigate(Screen.AppMain.route) }
    HorizontalPager(count = 3, state = pagerState) { page ->
        when (page) {
            0 -> GetInspiredScreen(
                pagerState = pagerState,
                isLastScreen = false,
                onSkipClick = { navigateToAppMain() })
            1 -> EasyAndHealthyScreen(
                pagerState = pagerState,
                isLastScreen = false,
                onSkipClick = { navigateToAppMain() })
            2 -> SaveYourFavouritiesScreen(
                pagerState = pagerState,
                isLastScreen = true,
                onGetStartedClick = { navigateToAppMain() }
            )
        }
    }
}

@Preview
@Composable
fun OnboardingMainScreenPreview() {
    OnboardingMainScreen()
}

@Preview(widthDp = 360, heightDp = 722)
@Composable
fun OnboardingMainScreenPreview_GalaxyS20FE() {
    ComposeSandboxTheme {
        OnboardingMainScreen()
    }
}