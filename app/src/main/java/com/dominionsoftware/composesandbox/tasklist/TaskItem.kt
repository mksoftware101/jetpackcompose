package com.dominionsoftware.composesandbox.tasklist

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskItemStateful(task: Task, onDelete: (index: Int) -> Unit, modifier: Modifier) {
    var checked by rememberSaveable { mutableStateOf(false) }

    TaskItemStateless(
        task,
        checked,
        onCheckedChanged = { newState -> checked = newState },
        onDelete,
        modifier
    )
}

@Composable
fun TaskItemStateless(
    task: Task,
    checked: Boolean,
    onCheckedChanged: (newChecked: Boolean) -> Unit,
    onDelete: (index: Int) -> Unit,
    modifier: Modifier
) {
    Row(modifier) {
        Text(text = task.text, modifier = Modifier.weight(1f))
        Checkbox(checked, onCheckedChanged)
        Button(onClick = { onDelete(task.id) }) {
            Text(text = "Delete")
        }
    }
}

@Composable
@Preview
fun TaskItemComposablePreview() {
    TaskItemStateless(
        task = fakeTask,
        checked = false,
        onCheckedChanged = {},
        onDelete = {},
        modifier = Modifier.padding(all = 4.dp)
    )
}

val fakeTask = Task(1, "Task with number 1")