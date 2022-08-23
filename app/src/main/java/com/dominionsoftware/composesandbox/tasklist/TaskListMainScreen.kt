package com.dominionsoftware.composesandbox.tasklist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme

@Composable
fun TaskListMainScreen() {
    ComposeSandboxTheme {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            TaskListStateful(fakeData)
        }
    }
}

@Composable
fun TaskListStateful(data: MutableList<Task>) {
    val _tasks = remember { data.toMutableStateList() }

    LazyColumn {
        items(_tasks) { task ->
            TaskItemStateful(
                task = task,
                onDelete = { index ->
                    _tasks.removeAt(index)
                },
                modifier = Modifier.padding(all = 4.dp))
        }
    }
}

val fakeData = MutableList(100) { index -> Task(index, "Task with number $index") }

@Composable
@Preview
fun TaskListStatefulPreview() {
    TaskListStateful(data = fakeData)
}


