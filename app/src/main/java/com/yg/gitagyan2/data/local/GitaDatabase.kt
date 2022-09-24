package com.yg.gitagyan2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ChapterEntity::class],
    version = 1
)
abstract class GitaDatabase : RoomDatabase() {
    abstract val dao: GitaDao
}