package com.yg.gitagyan2.data.remote

import com.yg.gitagyan2.domain.model.Chapter
import com.yg.gitagyan2.domain.model.GitaSlokasItem
import com.yg.gitagyan2.domain.model.Sloka

interface GitaApi {
    suspend fun getGitaChapters(): List<Chapter>?
    suspend fun getGitaSlokas(chapter: Int): GitaSlokasItem?
}