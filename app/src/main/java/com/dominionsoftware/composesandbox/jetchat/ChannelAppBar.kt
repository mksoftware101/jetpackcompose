package com.dominionsoftware.composesandbox.jetchat

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChannelAppBar(
    name: String,
    membersCount: String,
    onOpenSidebar: () -> Unit,
    onSearchClick: () -> Unit,
    onInfoClick: () -> Unit,
    modifier: Modifier
) {
    JetChatAppBar(
        modifier = modifier,
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = name, style = MaterialTheme.typography.titleMedium)
                Text(text = membersCount, style = MaterialTheme.typography.bodySmall)
            }
        },
        actions = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "search",
                modifier = Modifier
                    .clickable(onClick = {})
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            )
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "info",
                modifier = Modifier
                    .clickable(onClick = {})
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )
        },
        onNavIconClick = { Log.d("TAG", "onSidebar clicked") },
    )
}

@Preview
@Composable
fun ChannelAppBarPreview() {
    ChannelAppBar(
        name = "#composers",
        membersCount = "42 members",
        onOpenSidebar = { /*TODO*/ },
        onSearchClick = { /*TODO*/ },
        onInfoClick = { /*TODO*/ },
        modifier = Modifier
    )
}