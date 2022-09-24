package com.yg.gitagyan2.domain.repository

import com.yg.gitagyan2.domain.model.Chapter
import com.yg.gitagyan2.domain.model.GitaSlokasItem
import com.yg.gitagyan2.domain.model.Sloka
import com.yg.utils.Resource

interface GitaGyanRepository {
    suspend fun getChapterNames(): Resource<List<Chapter>>
    suspend fun getChapterSlokas(chapter: Int): Resource<GitaSlokasItem>
}