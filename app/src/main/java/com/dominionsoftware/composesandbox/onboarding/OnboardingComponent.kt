package com.dominionsoftware.composesandbox.onboarding

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dominionsoftware.composesandbox.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingComponent(
    @StringRes title: Int,
    @StringRes text: Int,
    @DrawableRes picture: Int,
    @ColorRes backgroundColor: Int,
    pagerState: PagerState,
    isLastScreen: Boolean,
    modifier: Modifier = Modifier
) {
    SystemBarsColor()

    val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = backgroundColor))
            .verticalScroll(rememberScrollState())
            .padding(start = 32.dp, end = 32.dp, bottom = bottomPadding)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = picture),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = title),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h4,
            letterSpacing = 1.5.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            text = stringResource(id = text),
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6.copy(lineHeight = 24.sp),
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .padding(top = 24.dp)
        )
        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .padding(top = 36.dp)
        )
        Spacer(modifier = Modifier.weight(2f))

        val buttonsModifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)

        if (isLastScreen) {
            GetStartedButton(buttonsModifier)
        } else {
            OnboardingNavigationButtons(buttonsModifier)
        }
    }
}

@Composable
private fun OnboardingNavigationButtons(modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.onboardingButtonSkip),
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Light,
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.onboardingButtonNext),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Image(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Next",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
            )
        }
    }
}

@Composable
fun GetStartedButton(modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Surface(
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier.weight(1f)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.color5)),
                onClick = { /*TODO*/ },
                modifier = Modifier.height(56.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.onboardingThirdScreenGetStartedButton),
                    style = MaterialTheme.typography.button.copy(fontSize = 18.sp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun SystemBarsColor() {
    val systemUiController = rememberSystemUiController()
    val isDarkMode = isSystemInDarkTheme()

    DisposableEffect(systemUiController, isDarkMode) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = isDarkMode,
            isNavigationBarContrastEnforced = false,
        )

        onDispose {}
    }
}