package com.dominionsoftware.composesandbox.codelab.basiclayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dominionsoftware.composesandbox.R
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme

class MySootheMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheApp()
        }
    }

    @Composable
    fun MySootheApp() {
        SearchBar(modifier = Modifier.padding(8.dp))
    }

    @Composable
    fun SearchBar(modifier: Modifier) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Image(imageVector = Icons.Default.Search, contentDescription = "Search")
            },
            placeholder = {
                Text(text = stringResource(id = R.string.placeholder_search))
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
            modifier = modifier
                .heightIn(min = 56.dp) // It's better approach to set min height for cases when user increase system fonts
                .fillMaxWidth()
        )
    }

    @Composable
    @Preview
    fun SearchBarPreview() {
        ComposeSandboxTheme {
            SearchBar(modifier = Modifier.padding(8.dp))
        }
    }

}