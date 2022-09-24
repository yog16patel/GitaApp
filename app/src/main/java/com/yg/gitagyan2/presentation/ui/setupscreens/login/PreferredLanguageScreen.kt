package com.yg.gitagyan2.presentation.ui.setupscreens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yg.gitagyan2.presentation.res.Dimensions
import com.yg.gitagyan2.presentation.ui.theme.Bhagwa
import com.yg.gitagyan2.presentation.ui.theme.TextBlack
import com.yg.gitagyan2.presentation.ui.theme.TextWhite
import com.yg.utils.fontFamily

val languages = listOf(
    "English",
    "हिन्दी",
    "ગુજરાતી"
)

@Composable
fun PreferredLanguageScreen(
    loginViewModel: LoginViewModel,
    navigateToUserHomeScreen : () -> Unit
) {
    val state = loginViewModel.userPreferences

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Bhagwa)
            .fillMaxSize()

    ) {
        Text(
            text = "Preferred Language,",
            color = TextWhite,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp
        )

        Spacer(modifier = Modifier.height(Dimensions.gitaPadding6x))
        LazyColumn {
            items(languages.size){ i->
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimensions.gitaPadding6x),
                    border = BorderStroke(1.dp, Bhagwa),
                    elevation = null,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    onClick = {
                        loginViewModel.savePreferredLanguage(languages[i])
                        //navigator.navigate(UserHomeScreenDestination())

                    }) {
                    Text(
                        text = languages[i],
                        modifier = Modifier
                            .padding(Dimensions.gitaPadding),
                        color = TextBlack,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.height(Dimensions.gitaPadding))
            }
        }

    }
    if(state.language.isNotEmpty()){
        navigateToUserHomeScreen()
    }

}
