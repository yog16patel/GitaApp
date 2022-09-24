package com.yg.gitagyan2.domain.remote

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.getValue
import com.yg.gitagyan2.data.remote.GitaApi
import com.yg.gitagyan2.data.repository.await
import com.yg.gitagyan2.domain.model.Chapter
import com.yg.gitagyan2.domain.model.GitaSlokasItem
import com.yg.gitagyan2.domain.model.Sloka
import com.yg.gitagyan2.domain.model.Translations
import javax.inject.Inject

class GitaApiImpl @Inject constructor(
    private val database: DatabaseReference //Firebase database
): GitaApi {
    override suspend fun getGitaChapters(): List<Chapter>? {
        val v = database.child("chapters").get().await()
        return v.getValue<List<Chapter>>()
    }

    override suspend fun getGitaSlokas(chapter: Int): GitaSlokasItem? {
        val geetaReference = database.child("Geeta")
        val v = geetaReference.child((chapter -1).toString()).get().await()
        return v.getValue<GitaSlokasItem>()
    }

}