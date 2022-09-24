package com.yg.gitagyan2.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.yg.gitagyan2.domain.repository.FirebaseAuthDataRepository
import javax.inject.Inject

class FirebaseAuthDataRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : FirebaseAuthDataRepository {

    override suspend fun authenticate(
        email: String,
        password: String
    ): FirebaseUser? {
        firebaseAuth.createUserWithEmailAndPassword(
            email,
            password
        ).await()
        return firebaseAuth.currentUser
    }
}