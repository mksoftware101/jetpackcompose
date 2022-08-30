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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun OnboardingComponent(
    @StringRes title: Int,
    @StringRes text: Int,
    @DrawableRes picture: Int,
    @ColorRes backgroundColor: Int,
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
                    color = MaterialTheme.colors.onPrimary,
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
                    color = MaterialTheme.colors.onPrimary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h6.copy(lineHeight = 24.sp),
                    fontWeight = FontWeight.Light,
                )
            }
        }
        if (isLastScreen) {
            GetStartedButton()
        } else {
            OnboardingNavigationButtons()
        }
    }
}

@Composable
private fun OnboardingNavigationButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 20.dp)
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
fun GetStartedButton() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 20.dp)
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
private fun SystemBarsColor(backgroundColor: Int) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = colorResource(id = backgroundColor),
        darkIcons = isSystemInDarkTheme()
    )
}