package com.dominionsoftware.composesandbox.watercounter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatefulWaterCounter() {
    var counter by rememberSaveable { mutableStateOf(0) }

    StatelessWaterCounter(
        counter = counter,
        onCount = {
            counter++
        },
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun StatelessWaterCounter(counter: Int, onCount: () -> Unit, modifier: Modifier) {
    Column(modifier) {
        Text(text = "You drink $counter glasses of water")
        OutlinedButton(
            onClick = onCount,
            enabled = counter < 10,
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "Click to drink more water")
        }
    }
}

@Preview
@Composable
fun DrinkWaterCounterPreview() {
    StatelessWaterCounter(counter = 0, onCount = {}, modifier = Modifier.padding(8.dp))
}

