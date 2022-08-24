package com.dominionsoftware.composesandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dominionsoftware.composesandbox.wellnesstasks.WellnessTaskMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            WaterCounterMainScreen()
            WellnessTaskMainScreen()
        }
    }
}