package com.yg.gitagyan2.presentation.ui.setupscreens.login

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.yg.gitagyan2.R
import com.yg.gitagyan2.presentation.res.Dimensions
import com.yg.gitagyan2.presentation.ui.setupscreens.login.util.LoadingState
import com.yg.gitagyan2.presentation.ui.social_media.SocialMediaButton
import com.yg.gitagyan2.presentation.ui.theme.WhiteBackground

@Composable
fun GoogleSignInComponent(
    loginViewModel: LoginViewModel = hiltViewModel(),
    loginCallback: (LoadingState.Status) -> Unit
) {

    val state =  loginViewModel.loadingState
    val context = LocalContext.current
    val token = stringResource(R.string.default_web_client_id)

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
            loginViewModel.signInWithCredential(credential = credential)
        } catch (e: ApiException) {
            Log.e("Yogesh", "Google sign in failed", e)
            loginViewModel.signInFailed()
        }
    }
    SocialMediaButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimensions.gitaPadding5x, vertical = Dimensions.gitaPadding),
        text = "Sign In with Google",
        loadingText = "Sign In...",
        backgroundColor = WhiteBackground,
        icon = R.drawable.ic_google_logo,
        onClicked = {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(token)
                .requestEmail()
                .build()
            val googleSignInClient = GoogleSignIn.getClient(context, gso)
            launcher.launch(googleSignInClient.signInIntent)
        }
    )
    loginCallback(state.status)
}
