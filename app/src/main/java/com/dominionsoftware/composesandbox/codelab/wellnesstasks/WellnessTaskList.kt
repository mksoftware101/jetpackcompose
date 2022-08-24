package com.dominionsoftware.composesandbox.codelab.wellnesstasks

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskList(
    list: List<WellnessTask>,
    onDelete: (WellnessTask) -> Unit,
    modifier: Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items = list, key = { task -> task.id }) { task ->
            StatefulWellnessTaskItem(
                taskName = task.label,
                modifier = Modifier.padding(all = 4.dp),
                onClose = {
                    onDelete(task)
                }
            )
        }
    }
}

@Composable
@Preview
fun TaskListStatefulPreview() {
    WellnessTaskList(list = wellnessTasks, onDelete = {}, Modifier)
}


