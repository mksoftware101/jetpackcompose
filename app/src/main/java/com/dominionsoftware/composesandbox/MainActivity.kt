package com.dominionsoftware.composesandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme
import com.dominionsoftware.composesandbox.onboarding.GetInspiredScreen
import com.dominionsoftware.composesandbox.onboarding.OnboardingMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSandboxTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    WaterCounterMainScreen()
//                    WellnessScreen()
                    OnboardingMainScreen()
                }
            }
        }
    }
}