package com.yg.gitagyan2.presentation.ui.setupscreens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yg.gitagyan2.R
import com.yg.gitagyan2.presentation.res.Dimensions
import com.yg.gitagyan2.presentation.res.Dimensions.splashImageHeight
import com.yg.gitagyan2.presentation.res.Dimensions.splashImageWeight
import com.yg.gitagyan2.presentation.ui.setupscreens.login.util.loginResponse
import com.yg.gitagyan2.presentation.ui.theme.Bhagwa
import com.yg.gitagyan2.presentation.ui.theme.TextWhite
import com.yg.utils.fontFamily
import java.util.*

@Composable
fun SplashScreen(
    loginViewModel: LoginViewModel,
    navigateToUserHomeScreen: () -> Unit,
    navigateToPreferredLanguageScreen : () ->Unit,
    navigateToSignupScreen: () -> Unit
) {

    val state = loginViewModel.loadingState
    val userPreferencesStat = loginViewModel.userPreferences
    var showProgressBar by remember {
        mutableStateOf(true)
    }

    loginResponse(state.status, onSuccess = {
        if (userPreferencesStat.language.isNotEmpty()) {
            navigateToUserHomeScreen()
        }else {
            navigateToPreferredLanguageScreen()
        }
    }, onFailed = {
        showProgressBar = false
    })

    if (!showProgressBar) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.splash_screen),
                contentDescription = "splash_image",
                Modifier
                    .height(splashImageHeight)
                    .width(splashImageWeight)
            )
            Text(
                text = "Shrimad Bhagvat Gita".uppercase(Locale.getDefault()),
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(Dimensions.gitaPadding))
            Text(
                text = "Helps you to live better.",
                fontSize = 15.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(Dimensions.gitaPadding5x))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimensions.gitaPadding2x),
                onClick = {
                    //navigator.navigate(SignupScreenDestination())
                }) {
                Text(
                    text = "GET STARTED",
                    modifier = Modifier
                        .padding(6.dp),
                    color = TextWhite
                )
            }
            Button(
                border = BorderStroke(1.dp, Bhagwa),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimensions.gitaPadding2x),
                elevation = null,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                onClick = {
                    navigateToSignupScreen()
                }) {
                Text(
                    text = "I HAVE AN ACCOUNT",
                    modifier = Modifier
                        .padding(6.dp),
                    color = Bhagwa
                )
            }

        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (showProgressBar) {
            CircularProgressIndicator()
        }
    }
}
