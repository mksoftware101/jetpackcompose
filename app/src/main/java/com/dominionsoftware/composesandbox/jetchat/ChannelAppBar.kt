package com.dominionsoftware.composesandbox.jetchat

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChannelAppBar(
    name: String,
    membersCount: String,
    onOpenSidebar: () -> Unit,
    modifier: Modifier
) {
    var isSearchAlertDialog by remember { mutableStateOf(false) }
    var isInfoAlertDialog by remember { mutableStateOf(false) }

    showSearchAlertDialogBy(isSearchAlertDialog) {
        isSearchAlertDialog = false
    }

    showInfoAlertDialogBy(isInfoAlertDialog) {
        isInfoAlertDialog = false
    }

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
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .clickable(onClick = {
                        isSearchAlertDialog = true
                    })
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            )
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "info",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .clickable(onClick = {
                        isInfoAlertDialog = true
                    })
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )
        },
        onNavIconClick = { Log.d("TAG", "onSidebar clicked") },
    )
}

@Composable
private fun showSearchAlertDialogBy(isSearchAlertDialog: Boolean, onDismiss: () -> Unit) {
    if (isSearchAlertDialog) {
        JetChatAlertDialog(
            title = "Search not available",
            text = "Sorry, but Search functionality is not available right now.",
            onDismiss = onDismiss
        )
    }
}

@Composable
private fun showInfoAlertDialogBy(isInfoAlertDialog: Boolean, onDismiss: () -> Unit) {
    if (isInfoAlertDialog) {
        JetChatAlertDialog(
            title = "Info not available",
            text = "Sorry, but Info functionality is not available right now.",
            onDismiss = onDismiss
        )
    }
}

@Preview
@Composable
fun ChannelAppBarPreview() {
    ChannelAppBar(
        name = "#composers",
        membersCount = "42 members",
        onOpenSidebar = { /*TODO*/ },
        modifier = Modifier
    )
}