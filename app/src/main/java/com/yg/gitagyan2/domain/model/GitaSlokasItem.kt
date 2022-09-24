package com.yg.gitagyan2.domain.model


data class GitaSlokasItem(
    var chapter_number: Int = 0,
    var slokas: List<Sloka> = emptyList()
)