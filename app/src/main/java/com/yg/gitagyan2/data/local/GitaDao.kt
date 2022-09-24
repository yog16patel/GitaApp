package com.yg.gitagyan2.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface GitaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGitaChapterList(chapterList: List<ChapterEntity>)
}