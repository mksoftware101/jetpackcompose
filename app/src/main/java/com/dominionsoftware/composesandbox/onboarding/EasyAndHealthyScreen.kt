package com.dominionsoftware.composesandbox.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dominionsoftware.composesandbox.R

@Composable
fun EasyAndHealthyScreen() {
    OnboardingComponent(
        title = R.string.onboardingSecondScreenTitle,
        text = R.string.onboardingSecondScreenText,
        picture = R.drawable.onboarding_pic2,
        backgroundColor = R.color.color4,
        isLastScreen = false
    )
}

@Preview(name = "GalaxyS 20FE", widthDp = 360, heightDp = 722)
@Composable
fun EasyAndHealthyScreenPreview_GalaxyS20FE() {
    EasyAndHealthyScreen()
}

@Preview(name = "GalaxyS 20FE dark mode", widthDp = 360, heightDp = 722, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun EasyAndHealthyScreenPreview_GalaxyS20FE_DarkMode() {
    EasyAndHealthyScreen()
}

@Preview(name = "Smaller screen", widthDp = 360, heightDp = 640)
@Composable
fun OnboardingScreenPreview_GalaxyS7_LowerScreen() {
    EasyAndHealthyScreen()
}