package com.dominionsoftware.composesandbox.codelab.basiclayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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

    @Composable
    fun AlignYourBodyElement(
        @DrawableRes drawable: Int,
        @StringRes text: Int,
        modifier: Modifier
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
            Image(
                painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
            )
            Text(
                stringResource(id = text),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
            )
        }
    }

    @Composable
    @Preview
    fun AlignYourBodyElementPreview() {
        AlignYourBodyElement(
            drawable = R.drawable.ab1_inversions,
            text = R.string.ab1_inversions,
            modifier = Modifier
        )
    }

    @Composable
    fun FavouriteCollectionCard(
        @DrawableRes drawable: Int,
        @StringRes text: Int,
        modifier: Modifier
    ) {
        Surface(shape = MaterialTheme.shapes.small, modifier = modifier) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(192.dp)
            ) {
                Image(
                    painterResource(id = drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(56.dp)
                )
                Text(
                    stringResource(id = text),
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }

    @Composable
    @Preview
    fun FavouriteCollectionCardPreview() {
        FavouriteCollectionCard(
            drawable = R.drawable.fc2_nature_meditations,
            text = R.string.fc2_nature_meditations,
            Modifier
        )
    }
}