package com.dominionsoftware.composesandbox.drinkwatercounter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme

@Composable
fun DrinkWaterCounterMainScreen() {
    ComposeSandboxTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            DrinkWaterCounterStateful()
        }
    }
}

@Composable
private fun DrinkWaterCounterStateful() {
    var counter by remember { mutableStateOf(0) }
    var enabled by remember { mutableStateOf(true) }

    DrinkWaterCounterStateless(
        counter = counter,
        enabled = enabled,
        onCount = {
            counter++
            enabled = counter < 10
        })
}

@Composable
fun DrinkWaterCounterStateless(counter: Int, onCount: () -> Unit, enabled: Boolean) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "You drink $counter glasses of water")
        OutlinedButton(
            onClick = onCount,
            enabled = enabled,
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "Click to drink more water")
        }
    }
}

@Preview
@Composable
fun DrinkWaterCounterPreview() {
    DrinkWaterCounterStateless(counter = 0, onCount = {}, enabled = true)
}

