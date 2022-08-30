package com.dominionsoftware.composesandbox.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingMainScreen() {
    val pagerState = rememberPagerState()
    HorizontalPager(count = 3, state = pagerState) { page ->
        when (page) {
            0 -> GetInspiredScreen(pagerState = pagerState, isLastScreen = false)
            1 -> EasyAndHealthyScreen(pagerState = pagerState, isLastScreen = false)
            2 -> SaveYourFavouritiesScreen(pagerState = pagerState, isLastScreen = true)
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