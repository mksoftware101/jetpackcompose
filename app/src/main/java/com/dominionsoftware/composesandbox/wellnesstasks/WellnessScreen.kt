package com.dominionsoftware.composesandbox.wellnesstasks

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel = viewModel()
) {
    WellnessTaskList(
        list = viewModel.tasks,
        onDelete = { wellnessTask ->
            viewModel.remove(wellnessTask)
        },
        modifier = modifier
    )
}