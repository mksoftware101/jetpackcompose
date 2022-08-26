package com.dominionsoftware.composesandbox.onboarding

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
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

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.color1))
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(46.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.onboarding_pic1),
                    contentDescription = null,
                    modifier = Modifier.weight(1f),
                    contentScale = ContentScale.FillWidth
                )
            }
            Spacer(modifier = Modifier.height(36.dp))
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(id = R.string.onboardingFirstScreenTitle),
                    color = colorResource(id = R.color.white),
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
                    text = stringResource(id = R.string.onboardingFirstScreenText),
                    color = colorResource(id = R.color.white),
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
                .padding(all = 32.dp)
        ) {
            Text(
                text = stringResource(id = R.string.onboardingButtonSkip),
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Light,
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.onboardingButtonNext),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Image(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Next",
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.white))
                )
            }

        }
    }
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