package com.yg.gitagyan2.data.repository

import com.yg.gitagyan2.data.remote.GitaApi
import com.yg.gitagyan2.domain.model.Chapter
import com.yg.gitagyan2.domain.model.GitaSlokasItem
import com.yg.gitagyan2.domain.repository.GitaGyanRepository
import com.yg.utils.Resource
import com.yg.utils.Success
import javax.inject.Inject

class GitaGyanRepositoryImpl @Inject constructor(
    private val api: GitaApi,
) : GitaGyanRepository {
    override suspend fun getChapterNames(): Resource<List<Chapter>> {
        return Success(api.getGitaChapters())
    }

    override suspend fun getChapterSlokas(chapter: Int) = Success(api.getGitaSlokas(chapter))


}