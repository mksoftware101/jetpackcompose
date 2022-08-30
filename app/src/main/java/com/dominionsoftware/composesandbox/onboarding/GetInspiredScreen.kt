package com.dominionsoftware.composesandbox.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dominionsoftware.composesandbox.R
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme

@Composable
fun GetInspiredScreen() {
    OnboardingComponent(
        title = R.string.onboardingFirstScreenTitle,
        text = R.string.onboardingFirstScreenText,
        picture = R.drawable.onboarding_pic1,
        backgroundColor = R.color.color1,
        isLastScreen = false
    )
}

@Preview(widthDp = 360, heightDp = 722)
@Composable
fun OnboardingScreenPreview_GalaxyS20FE() {
    ComposeSandboxTheme {
        GetInspiredScreen()
    }
}

@Preview(widthDp = 360, heightDp = 722, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OnboardingScreenDarkModePreview_GalaxyS20FE() {
    ComposeSandboxTheme {
        GetInspiredScreen()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun OnboardingScreenPreview_GalaxyS7() {
    ComposeSandboxTheme {
        GetInspiredScreen()
    }
}