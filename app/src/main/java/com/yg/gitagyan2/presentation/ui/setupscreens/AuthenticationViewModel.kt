package com.yg.gitagyan2.presentation.ui.setupscreens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yg.gitagyan2.domain.repository.FirebaseAuthDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val repository: FirebaseAuthDataRepository
) : ViewModel() {

    val state = mutableStateOf("")

    fun signUp(email: String, password: String){
        viewModelScope.launch {
            repository.authenticate(email, password)?.let {
                state.value = "Authenticated"
            }?: run {
                state.value = "failed"
            }
        }
    }

}