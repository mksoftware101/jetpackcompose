package com.dominionsoftware.composesandbox.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dominionsoftware.composesandbox.R
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun GetInspiredScreen(pagerState: PagerState, onSkipClick: () -> Unit, isLastScreen: Boolean) {
    OnboardingComponent(
        title = R.string.onboardingFirstScreenTitle,
        text = R.string.onboardingFirstScreenText,
        picture = R.drawable.onboarding_pic1,
        backgroundColor = R.color.color1,
        pagerState = pagerState,
        onSkipClick = onSkipClick,
        isLastScreen = isLastScreen
    )
}

@OptIn(ExperimentalPagerApi::class)
@Preview(widthDp = 360, heightDp = 722)
@Composable
fun OnboardingScreenPreview_GalaxyS20FE() {
    ComposeSandboxTheme {
        GetInspiredScreen(pagerState = PagerState(0), onSkipClick = {}, isLastScreen = false)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(widthDp = 360, heightDp = 722, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OnboardingScreenDarkModePreview_GalaxyS20FE() {
    ComposeSandboxTheme {
        GetInspiredScreen(pagerState = PagerState(0), onSkipClick = {}, isLastScreen = false)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun OnboardingScreenPreview_GalaxyS7() {
    ComposeSandboxTheme {
        GetInspiredScreen(pagerState = PagerState(0), onSkipClick = {}, isLastScreen = false)
    }
}