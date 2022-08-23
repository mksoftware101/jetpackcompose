package com.dominionsoftware.composesandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dominionsoftware.composesandbox.drinkwatercounter.DrinkWaterCounterMainScreen
import com.dominionsoftware.composesandbox.tasklist.TaskListMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            DrinkWaterCounterMainScreen()
            TaskListMainScreen()
        }
    }
}