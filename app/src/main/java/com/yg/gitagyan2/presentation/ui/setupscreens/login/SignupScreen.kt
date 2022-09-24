package com.yg.gitagyan2.presentation.ui.setupscreens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yg.gitagyan2.presentation.res.Dimensions
import com.yg.gitagyan2.presentation.ui.setupscreens.AuthenticationViewModel
import com.yg.gitagyan2.presentation.ui.setupscreens.login.util.loginResponse
import com.yg.gitagyan2.presentation.ui.theme.*
import com.yg.utils.fontFamily

@Composable
fun SignupScreen(
    loginViewModel: LoginViewModel,
    authenticationViewModel: AuthenticationViewModel,
    navigateToUserHomeScreen: () -> Unit
    ) {
    var textFieldUserNameState by remember {
        mutableStateOf("")
    }
    var textFieldPasswordState by remember {
        mutableStateOf("")
    }
    val userPreferencesStat = loginViewModel.userPreferences

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Sign up",
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(Dimensions.gitaPadding))
        OutlinedTextField(
            value = textFieldUserNameState,
            label = {
                Text(text = "First Name")
            },
            onValueChange = {
                textFieldUserNameState = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Bhagwa,
                unfocusedBorderColor = Unfocused,
                placeholderColor = Unfocused
            )
        )
        Spacer(modifier = Modifier.height(Dimensions.gitaPadding))
        OutlinedTextField(
            value = textFieldUserNameState,
            label = {
                Text(text = "Email Address")
            },
            onValueChange = {
                textFieldUserNameState = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Bhagwa,
                unfocusedBorderColor = Unfocused,
                placeholderColor = Unfocused
            )
        )
        Spacer(modifier = Modifier.height(Dimensions.gitaPadding))
        OutlinedTextField(
            value = textFieldPasswordState,
            label = {
                Text(text = "Password")
            },
            onValueChange = {
                textFieldPasswordState = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Bhagwa,
                unfocusedBorderColor = Unfocused,
                placeholderColor = Unfocused
            )
        )
        Spacer(modifier = Modifier.height(Dimensions.gitaPadding))
        OutlinedTextField(
            value = textFieldPasswordState,
            label = {
                Text(text = "Confirm Password")
            },
            onValueChange = {
                textFieldPasswordState = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Bhagwa,
                unfocusedBorderColor = Unfocused,
                placeholderColor = Unfocused
            )
        )

        Spacer(modifier = Modifier.height(Dimensions.gitaPadding2x))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimensions.gitaPadding5x),
            onClick = {
                authenticationViewModel.signUp("yog16patelss@gmail.com","Testing")
            }) {
            Text(
                text = "SIGN UP",
                modifier = Modifier
                    .padding(6.dp),
                color = TextWhite
            )
        }
        Spacer(modifier = Modifier.height(Dimensions.gitaPaddingHalf))
        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = AccountTextColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Already have an account?")
            }
            withStyle(
                style = SpanStyle(
                    color = Bhagwa,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(" Log in")
            }
        })
        Spacer(modifier = Modifier.height(Dimensions.gitaPaddingHalf))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                color = DividerColor,
                modifier = Modifier
                    .height(1.dp)
                    .weight(0.45f)
            )
            Text(
                text = "OR",
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                color= Bhagwa,
                modifier = Modifier.weight(0.1f)
            )
            Divider(
                color = DividerColor,
                modifier = Modifier
                    .height(1.dp)
                    .weight(0.45f)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        GoogleSignInComponent {
            loginResponse(it,{
                if(userPreferencesStat.language.isNotEmpty()){
                    navigateToUserHomeScreen()
                }
            },{})
        }

    }

}