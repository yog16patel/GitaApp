package com.yg.gitagyan2.presentation.ui.setupscreens.login.util

import android.util.Log

internal fun loginResponse(
    status: LoadingState.Status,
    onSuccess : () -> Unit,
    onFailed : () -> Unit
) {
    when (status) {
        LoadingState.Status.LOGGED_IN, LoadingState.Status.SUCCESS -> {
            Log.e("Yogesh : ", "Logged in ")
            onSuccess()
        }
        LoadingState.Status.IDLE -> {}
        else -> {
            Log.e("Yogesh : ", "Logged in else ${status.name}")
            onFailed()
        }
    }
}
