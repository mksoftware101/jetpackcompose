package com.dominionsoftware.composesandbox.wellnesstasks

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme

@Composable
fun WellnessTaskMainScreen() {
    ComposeSandboxTheme {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            val list = remember { wellnessTasks.toMutableStateList() }
            WellnessTaskList(
                list = list,
                modifier = Modifier,
                onDelete = { wellnessTask ->
                    list.remove(wellnessTask)
                }
            )
        }
    }
}