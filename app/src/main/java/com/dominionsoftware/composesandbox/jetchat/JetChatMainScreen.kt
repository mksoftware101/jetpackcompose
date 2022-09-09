package com.dominionsoftware.composesandbox.jetchat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun JetChatMainScreen() {
    Column {
        ChannelAppBar(
            name = "#composers",
            membersCount = "42 members",
            onOpenSidebar = {},
            modifier = Modifier.statusBarsPadding()
        )
        Messages(modifier = Modifier.padding(all = 16.dp))
        UserInput()
    }
}

@Composable
fun Messages(modifier: Modifier) {
//    Icon(
//        imageVector = Icons.Default.Search,
//        contentDescription = "",
//        modifier = modifier.clickable(onClick = { Log.d("TAG", "Clicked!") }).padding(all = 32.dp)
//    )
//        Text(
//            text = "Hi, there",
//            modifier = Modifier
//                .padding(all = 16.dp)
//                .border(2.dp, Color.Magenta)
//
//        )
}

@Composable
fun UserInput() {

}

