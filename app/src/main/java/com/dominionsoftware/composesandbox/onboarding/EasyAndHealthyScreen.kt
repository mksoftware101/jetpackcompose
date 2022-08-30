package com.dominionsoftware.composesandbox.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dominionsoftware.composesandbox.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun EasyAndHealthyScreen(pagerState: PagerState, isLastScreen: Boolean) {
    OnboardingComponent(
        title = R.string.onboardingSecondScreenTitle,
        text = R.string.onboardingSecondScreenText,
        picture = R.drawable.onboarding_pic2,
        backgroundColor = R.color.color4,
        pagerState = pagerState,
        isLastScreen = isLastScreen
    )
}

@OptIn(ExperimentalPagerApi::class)
@Preview(name = "GalaxyS 20FE", widthDp = 360, heightDp = 722)
@Composable
fun EasyAndHealthyScreenPreview_GalaxyS20FE() {
    EasyAndHealthyScreen(pagerState = PagerState(0), isLastScreen = false)
}

@OptIn(ExperimentalPagerApi::class)
@Preview(name = "GalaxyS 20FE dark mode", widthDp = 360, heightDp = 722, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun EasyAndHealthyScreenPreview_GalaxyS20FE_DarkMode() {
    EasyAndHealthyScreen(pagerState = PagerState(0), isLastScreen = false)
}

@OptIn(ExperimentalPagerApi::class)
@Preview(name = "Smaller screen", widthDp = 360, heightDp = 640)
@Composable
fun OnboardingScreenPreview_GalaxyS7_LowerScreen() {
    EasyAndHealthyScreen(pagerState = PagerState(0), isLastScreen = false)
}