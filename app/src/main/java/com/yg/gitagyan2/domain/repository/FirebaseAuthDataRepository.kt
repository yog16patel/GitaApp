package com.yg.gitagyan2.domain.repository

import com.google.firebase.auth.FirebaseUser

interface FirebaseAuthDataRepository {
    suspend fun authenticate(
        email: String,
        password: String
    ): FirebaseUser?
}