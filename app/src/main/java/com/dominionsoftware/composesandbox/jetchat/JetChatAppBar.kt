package com.dominionsoftware.composesandbox.jetchat

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetChatAppBar(
    modifier: Modifier,
    onNavIconClick: () -> Unit = {},
    title: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = title,
        actions = actions,
        navigationIcon = {
            JetChatNavIcon(
                contentDescription = "navigation icon",
                modifier = Modifier
                    .clickable(onClick = { onNavIconClick() })
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )
        },
    )
}