package com.dominionsoftware.composesandbox.sandbox

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun ChatText() {
    Text(text = buildAnnotatedString {
        val rawText = "Ala has a cat"
        val starIndex = 8
        val endIndex = rawText.length
        append(rawText)
        addStyle(
            style = SpanStyle(
                color = Color(0xff64b5f6),
                fontSize = 18.sp,
                textDecoration = TextDecoration.Underline
            ), start = starIndex, end = endIndex
        )
        addStringAnnotation(
            tag = "URL",
            annotation = "https://github.com",
            start = starIndex,
            end = endIndex
        )
    }, style = MaterialTheme.typography.body1, )
}