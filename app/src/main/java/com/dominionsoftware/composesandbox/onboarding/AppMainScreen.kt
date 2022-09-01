package com.dominionsoftware.composesandbox.onboarding

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppMainScreen() {
    Text(text = "This is App screen", modifier = Modifier.padding(top = 32.dp, start = 32.dp))
}