package com.yg.gitagyan2.domain.repository

import com.yg.gitagyan2.data.remote.GitaUserFirebase
import com.yg.gitagyan2.data.remote.UserPreferencesFirebase

interface FirebaseDataRepository {
    suspend fun setUserInformation(gitaUserFirebase: GitaUserFirebase)
    suspend fun setUserPreferences(userPreferencesFirebase: UserPreferencesFirebase)
    suspend fun getUserInformation(userId : String): GitaUserFirebase?
    suspend fun getUserPreferences(userId: String) : UserPreferencesFirebase?
}