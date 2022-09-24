package com.yg.gitagyan2.domain.model

data class Chapter(
    var chapter_number: Int = 0 ,
    var translations: Translations = Translations.NO_OP
)