package com.dominionsoftware.composesandbox.wellnesstasks

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = wellnessTasks.toMutableStateList()
    val tasks get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }
}