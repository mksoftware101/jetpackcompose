package com.dominionsoftware.composesandbox.codelab.basiclayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dominionsoftware.composesandbox.R
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme
import java.util.*

class MySootheMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheApp()
        }
    }

    @Composable
    fun SearchBar(modifier: Modifier = Modifier) {
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
        modifier: Modifier = Modifier
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
        modifier: Modifier = Modifier
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

    @Composable
    fun AlignYourBodyRow(modifier: Modifier = Modifier) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(items = alignYourBodyData) { item ->
                AlignYourBodyElement(
                    drawable = item.drawable,
                    text = item.text
                )
            }
        }
    }

    @Composable
    @Preview
    fun AlignYourBodyRowPreview() {
        AlignYourBodyRow(Modifier)
    }

    @Composable
    fun FavouriteCollectionGrid(modifier: Modifier = Modifier) {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(count = 2),
            modifier = modifier.height(120.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(favoriteCollectionsData) { item ->
                FavouriteCollectionCard(drawable = item.drawable, text = item.text)
            }
        }
    }

    @Composable
    @Preview
    fun FavouriteCollectionGridPreview() {
        FavouriteCollectionGrid(Modifier)
    }

    @Composable
    fun HomeSection(
        @StringRes title: Int,
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Column(modifier = modifier) {
            Text(
                stringResource(id = title).uppercase(Locale.getDefault()),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                    .padding(16.dp)
            )
            content()
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFF0EAE2)
    @Composable
    fun HomeSectionPreview() {
        ComposeSandboxTheme {
            HomeSection(title = R.string.align_your_body) {
                AlignYourBodyRow()
            }
        }
    }

    @Composable
    fun HomeScreen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar(Modifier.padding(horizontal = 16.dp))
            HomeSection(title = R.string.align_your_body) {
                AlignYourBodyRow()
            }
            HomeSection(title = R.string.favorite_collections) {
                FavouriteCollectionGrid()
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFF0EAE2, heightDp = 180)
    @Composable
    fun HomeScreenPreview() {
        HomeScreen()
    }

    @Composable
    private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
            modifier = modifier,
        ) {
            BottomNavigationItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(Icons.Default.Spa, contentDescription = null)
                },
                label = {
                    Text(stringResource(id = R.string.bottom_navigation_home))
                }
            )
            BottomNavigationItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(Icons.Default.AccountCircle, contentDescription = null)
                },
                label = {
                    Text(stringResource(id = R.string.bottom_navigation_profile))
                }
            )
        }
    }

    @Preview
    @Composable
    fun SootheBottomNavigationPreview() {
        SootheBottomNavigation()
    }

    @Composable
    fun MySootheApp() {
        Scaffold(bottomBar = { SootheBottomNavigation() }) { padding ->
            HomeScreen()
        }
    }

    @Preview(widthDp = 360, heightDp = 640)
    @Composable
    fun MySootheAppPreview() {
        ComposeSandboxTheme {
            MySootheApp()
        }
    }

    private val alignYourBodyData = listOf(
        R.drawable.ab1_inversions to R.string.ab1_inversions,
        R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
        R.drawable.ab3_stretching to R.string.ab3_stretching,
        R.drawable.ab4_tabata to R.string.ab4_tabata,
        R.drawable.ab5_hiit to R.string.ab5_hiit,
        R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
    ).map { DrawableStringPair(it.first, it.second) }

    private val favoriteCollectionsData = listOf(
        R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
        R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
        R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
        R.drawable.fc4_self_massage to R.string.fc4_self_massage,
        R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
        R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
    ).map { DrawableStringPair(it.first, it.second) }

    private data class DrawableStringPair(
        @DrawableRes val drawable: Int,
        @StringRes val text: Int
    )
}