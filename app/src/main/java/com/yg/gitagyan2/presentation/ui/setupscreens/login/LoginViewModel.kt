package com.yg.gitagyan2.presentation.ui.setupscreens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.yg.gitagyan2.data.remote.GitaUserFirebase
import com.yg.gitagyan2.data.remote.UserPreferencesFirebase
import com.yg.gitagyan2.data.repository.await
import com.yg.gitagyan2.domain.repository.FirebaseDataRepository
import com.yg.gitagyan2.presentation.ui.setupscreens.login.util.LoadingState
import com.yg.gitagyan2.presentation.ui.setupscreens.model.GitaUser
import com.yg.gitagyan2.presentation.ui.setupscreens.model.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val firebaseDataRepository: FirebaseDataRepository
) : ViewModel() {

    var loadingState by mutableStateOf(LoadingState.IDLE)
    var currentUserState by mutableStateOf(GitaUser())
    var userPreferences by mutableStateOf(UserPreferences())

    init {
        viewModelScope.launch {
            val currentUser = FirebaseAuth.getInstance().currentUser
            loadingState = currentUser?.let {
                val gitaUser = it.toGitaUser()
                currentUserState = gitaUser
                userPreferences =
                    firebaseDataRepository.getUserPreferences(gitaUser.userId).toUserPreferences()

                 LoadingState.LOGGED_IN
            }?:  LoadingState.error("Login Failed")
        }
    }

    fun signInWithCredential(credential: AuthCredential) = viewModelScope.launch {
        try {
            loadingState = LoadingState.LOADING
            val response = Firebase.auth.signInWithCredential(credential).await()
            response.user?.let {
                currentUserState = it.toGitaUser()
                firebaseDataRepository.setUserInformation(it.toGitaUser().toGitaUserFirebase())
                loadingState = LoadingState.LOGGED_IN
            }
        } catch (e: Exception) {
            loadingState = LoadingState.error(e.localizedMessage)
        }
    }

    fun signInFailed() = viewModelScope.launch {
        loadingState = LoadingState.error("")
    }

    fun savePreferredLanguage(language: String) {
        viewModelScope.launch {
            firebaseDataRepository.setUserPreferences(
                UserPreferencesFirebase(
                    userId = currentUserState.userId,
                    language = language
                )
            )
            val response = firebaseDataRepository
                .getUserPreferences(userId = currentUserState.userId)
            userPreferences = response.toUserPreferences()
        }
    }
}

private fun UserPreferencesFirebase?.toUserPreferences(): UserPreferences {
    return this?.let {
        UserPreferences(
            language = language,
            currentProgress = currentProgress,
            currentAdyah = currentAdyah,
            currentSloka = currentSloka,
            likedSlokas = likedSlokas
        )
    } ?: UserPreferences.NO_OP
}

private fun FirebaseUser.toGitaUser(): GitaUser {
    val parts = this.displayName?.split(" ")
    val firstname = parts?.getOrNull(0)
    val lastname = parts?.getOrNull(1)
    return GitaUser(this.uid, firstname ?: "", lastname ?: "", email ?: "")
}

private fun GitaUser.toGitaUserFirebase() = GitaUserFirebase(
    this.userId,
    this.firstName,
    this.lastName,
    this.email
)
