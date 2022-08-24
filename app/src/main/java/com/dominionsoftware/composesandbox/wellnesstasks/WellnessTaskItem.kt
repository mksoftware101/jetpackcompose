package com.dominionsoftware.composesandbox.wellnesstasks

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatefulWellnessTaskItem(taskName: String, modifier: Modifier) {
    var checkedState by rememberSaveable { mutableStateOf(false) }

    StatelessWellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckedChange = { newValue -> checkedState = newValue },
        onClose = {},
        modifier = modifier
    )
}

@Composable
fun StatelessWellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (newChecked: Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = taskName,
            modifier = Modifier.weight(1f)
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
        )
        IconButton(onClick = onClose) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close"
            )
        }
    }
}

@Composable
@Preview
fun TaskItemComposablePreview() {
    StatelessWellnessTaskItem(
        taskName = "Task with number 1",
        checked = false,
        onCheckedChange = {},
        onClose = {},
        modifier = Modifier.padding(all = 4.dp)
    )
}