package com.dominionsoftware.composesandbox.jetchat

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dominionsoftware.composesandbox.R

@Composable
fun JetChatMainScreen() {
    val scrollState = rememberLazyListState()

    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            Messages(scrollState = scrollState, modifier = Modifier.padding(all = 16.dp))
            ChannelAppBar(
                name = "#composers",
                membersCount = "42 members",
                onOpenSidebar = {},
                modifier = Modifier.statusBarsPadding()
            )
        }
    }
}

@Composable
fun Messages(modifier: Modifier, scrollState: LazyListState) {
    LazyColumn(
        state = scrollState,
        contentPadding = WindowInsets.statusBars.add(WindowInsets(top = 90.dp)).asPaddingValues()
    ) {
        item {
            Message()
            Message(isUserMe = true)
        }
    }
}

@Composable
fun Message(isUserMe: Boolean = false) {
    val borderColor = if (isUserMe) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.tertiary
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.face),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(all = 16.dp)
                .border(width = 1.dp, color = borderColor, shape = CircleShape)
                .border(
                    width = 2.5.dp,
                    color = MaterialTheme.colorScheme.surface,
                    shape = CircleShape
                )
                .size(56.dp)
                .clip(CircleShape)
                .align(Alignment.Top)
        )
        AuthorNameTimestamp()
    }
}

@Composable
fun AuthorNameTimestamp() {
    Row(modifier = Modifier.padding(top = 16.dp)) {
        Text(
            text = "Alisha McNeal",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.alignBy(
                LastBaseline
            )
        )
        Text(
            text = "8:05 PM",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .alignBy(
                    LastBaseline
                )
                .padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun JetChatMainScreenPreview() {
    JetChatMainScreen()
}

@Preview(heightDp = 300)
@Composable
fun JetChatMainScreenPreview2() {
    JetChatMainScreen()
}

