package com.dominionsoftware.composesandbox.onboarding

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dominionsoftware.composesandbox.R

@Composable
fun SaveYourFavouritiesScreen() {
    OnboardingComponent(
        title = R.string.onboardingThirdScreenTitle,
        text = R.string.onboardingThirdScreenText,
        picture = R.drawable.onboarding_pic3,
        backgroundColor = R.color.color7,
        isLastScreen = true
    )
}

@Preview(name = "GalaxyS 20FE", widthDp = 360, heightDp = 722)
@Composable
fun SaveYourFavouritiesScreenPreview_GalaxyS20FE() {
    SaveYourFavouritiesScreen()
}

@Preview(
    name = "GalaxyS 20FE dark mode",
    widthDp = 360,
    heightDp = 722,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun SaveYourFavouritiesScreenPreview_GalaxyS20FE_DarkMode() {
    SaveYourFavouritiesScreen()
}

@Preview(name = "Smaller screen", widthDp = 360, heightDp = 640)
@Composable
fun SaveYourFavouritiesScreenPreview_GalaxyS7_LowerScreen() {
    SaveYourFavouritiesScreen()
}