package com.yg.gitagyan2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChapterEntity(
    var chapter_number: Int = 0 ,
    var translations: String ="",
    @PrimaryKey val id: Int? = null
)