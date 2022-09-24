package com.yg.gitagyan2.presentation.navcontroller

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yg.gitagyan2.presentation.ui.exploregita.ChapterList
import com.yg.gitagyan2.presentation.ui.exploregita.SlokaComposable
import com.yg.gitagyan2.presentation.ui.setupscreens.AuthenticationViewModel
import com.yg.gitagyan2.presentation.ui.setupscreens.GitaGyanViewModel
import com.yg.gitagyan2.presentation.ui.setupscreens.UserHomeScreen
import com.yg.gitagyan2.presentation.ui.setupscreens.login.*

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    val loginViewModel: LoginViewModel = viewModel()
    val authenticationViewModel: AuthenticationViewModel = viewModel()
    val gitaGyanViewModel: GitaGyanViewModel = viewModel()

    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("SplashScreen") {
            SplashScreen(
                loginViewModel = loginViewModel,
                navigateToUserHomeScreen = {
                    navController.navigate("UserHomeScreen")
                },
                navigateToPreferredLanguageScreen = {
                    navController.navigate("PreferredLanguageScreen")
                },
                navigateToSignupScreen = {
                    navController.navigate("SignupScreen")
                }
            )
        }
        composable("UserHomeScreen") {
            UserHomeScreen(
                navigateToChapterList = {
                    navController.navigate("ChapterList")
                }
            )
        }
        composable("PreferredLanguageScreen") {
            PreferredLanguageScreen(
                loginViewModel = loginViewModel,
                navigateToUserHomeScreen = {
                    navController.navigate("UserHomeScreen")
                },
            )
        }
        composable("SignupScreen") {
            SignupScreen(
                loginViewModel = loginViewModel,
                authenticationViewModel = authenticationViewModel,
                navigateToUserHomeScreen = {
                    navController.navigate("UserHomeScreen")
                },
            )
        }
        composable("LoginScreen") {
            LoginScreen(
                loginViewModel = loginViewModel,
                navigateToUserHomeScreen = {
                    navController.navigate("UserHomeScreen")
                },
                navigateToPreferredLanguageScreen = {
                    navController.navigate("PreferredLanguageScreen")
                }
            )
        }
        composable("SignupScreen") {
            SignupScreen(
                loginViewModel = loginViewModel,
                authenticationViewModel = authenticationViewModel,
                navigateToUserHomeScreen = {
                    navController.navigate("UserHomeScreen")
                }
            )
        }
        composable("ChapterList") {
            ChapterList(
                gitaGyanViewModel = gitaGyanViewModel,
                navigateToSlokaComposable = {
                    navController.navigate("SlokaComposable")
                }
            )
        }
        composable("SlokaComposable") {
            SlokaComposable(gitaGyanViewModel)
        }

    }
}