package com.dominionsoftware.composesandbox.watercounter

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme

@Composable
fun WaterCounterMainScreen() {
    ComposeSandboxTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            StatefulWaterCounter()
        }
    }
}