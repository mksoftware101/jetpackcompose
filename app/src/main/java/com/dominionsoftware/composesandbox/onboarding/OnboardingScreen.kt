package com.dominionsoftware.composesandbox.onboarding

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dominionsoftware.composesandbox.R
import com.dominionsoftware.composesandbox.ui.theme.ComposeSandboxTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun OnboardingScreen() {
    OnboardingComponent(
        title = R.string.onboardingFirstScreenTitle,
        text = R.string.onboardingFirstScreenText,
        picture = R.drawable.onboarding_pic1,
        backgroundColor = R.color.color1,
        textColor = R.color.white,
        isLastScreen = false
    )
}

@Composable
fun OnboardingComponent(
    @StringRes title: Int,
    @StringRes text: Int,
    @DrawableRes picture: Int,
    @ColorRes backgroundColor: Int,
    @ColorRes textColor: Int,
    isLastScreen: Boolean,
    modifier: Modifier = Modifier
) {
    SystemBarsColor(backgroundColor)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = backgroundColor))
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(46.dp))
            Row {
                Image(
                    painter = painterResource(id = picture),
                    contentDescription = null,
                    modifier = Modifier.weight(1f),
                    contentScale = ContentScale.FillWidth
                )
            }
            Spacer(modifier = Modifier.height(36.dp))
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(id = title),
                    color = colorResource(id = textColor),
                    style = MaterialTheme.typography.h4,
                    letterSpacing = 1.5.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(start = 32.dp, end = 32.dp)
            ) {
                Text(
                    text = stringResource(id = text),
                    color = colorResource(id = textColor),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h6.copy(lineHeight = 24.sp),
                    fontWeight = FontWeight.Light,
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 20.dp)
        ) {
            if (isLastScreen) {
                GetStartedButton()
            } else {
                OnboardingNavigationButtons(textColor)
            }
        }
    }
}

@Composable
private fun OnboardingNavigationButtons(textColor: Int) {
    Text(
        text = stringResource(id = R.string.onboardingButtonSkip),
        color = colorResource(id = textColor),
        fontWeight = FontWeight.Light,
    )
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(id = R.string.onboardingButtonNext),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = textColor)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Image(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Next",
            colorFilter = ColorFilter.tint(colorResource(id = textColor))
        )
    }
}

@Composable
fun GetStartedButton() {
    TODO("Not yet implemented")
}

@Composable
private fun SystemBarsColor(backgroundColor: Int) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = colorResource(id = backgroundColor),
        darkIcons = false
    )
}

@Preview(widthDp = 360, heightDp = 722)
@Composable
fun OnboardingScreenPreview_GalaxyS20FE() {
    ComposeSandboxTheme {
        OnboardingScreen()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun OnboardingScreenPreview_GalaxyS7() {
    ComposeSandboxTheme {
        OnboardingScreen()
    }
}