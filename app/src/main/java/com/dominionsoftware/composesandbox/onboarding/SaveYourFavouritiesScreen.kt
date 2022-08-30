package com.dominionsoftware.composesandbox.onboarding

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dominionsoftware.composesandbox.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SaveYourFavouritiesScreen(pagerState: PagerState, isLastScreen: Boolean) {
    OnboardingComponent(
        title = R.string.onboardingThirdScreenTitle,
        text = R.string.onboardingThirdScreenText,
        picture = R.drawable.onboarding_pic3,
        backgroundColor = R.color.color7,
        pagerState = pagerState,
        isLastScreen = isLastScreen
    )
}

@OptIn(ExperimentalPagerApi::class)
@Preview(name = "GalaxyS 20FE", widthDp = 360, heightDp = 722)
@Composable
fun SaveYourFavouritiesScreenPreview_GalaxyS20FE() {
    SaveYourFavouritiesScreen(pagerState = PagerState(0), isLastScreen = true)
}

@OptIn(ExperimentalPagerApi::class)
@Preview(
    name = "GalaxyS 20FE dark mode",
    widthDp = 360,
    heightDp = 722,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun SaveYourFavouritiesScreenPreview_GalaxyS20FE_DarkMode() {
    SaveYourFavouritiesScreen(pagerState = PagerState(0), isLastScreen = true)
}

@OptIn(ExperimentalPagerApi::class)
@Preview(name = "Smaller screen", widthDp = 360, heightDp = 640)
@Composable
fun SaveYourFavouritiesScreenPreview_GalaxyS7_LowerScreen() {
    SaveYourFavouritiesScreen(pagerState = PagerState(0), isLastScreen = true)
}