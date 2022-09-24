package com.yg.gitagyan2.data.repository

import com.google.firebase.database.DatabaseReference
import com.yg.gitagyan2.data.remote.GitaUserFirebase
import com.yg.gitagyan2.data.remote.UserPreferencesFirebase
import com.yg.gitagyan2.domain.repository.FirebaseDataRepository
import javax.inject.Inject

class FirebaseDataRepositoryImpl @Inject constructor(
    private val database: DatabaseReference
) : FirebaseDataRepository {
    override suspend fun setUserInformation(gitaUserFirebase: GitaUserFirebase) {
       database.child(USER)
            .child(gitaUserFirebase.userId)
            .setValue(gitaUserFirebase)
    }

    override suspend fun setUserPreferences(userPreferencesFirebase: UserPreferencesFirebase) {
        database.child(PREFERENCES)
            .child(userPreferencesFirebase.userId)
            .setValue(userPreferencesFirebase)
            .await()
    }

    override suspend fun getUserInformation(userId: String): GitaUserFirebase? {
        val v = database
            .child(USER)
            .child(userId)
            .get()
            .await()

        return v.getValue(GitaUserFirebase::class.java)
    }

    override suspend fun getUserPreferences(userId: String): UserPreferencesFirebase? {
        val response = database.child(PREFERENCES)
            .child(userId)
            .get()
            .await()

        return response.getValue(UserPreferencesFirebase::class.java)
    }

    companion object{
        private const val PREFERENCES = "preferences"
        private const val USER = "USER"
    }
}