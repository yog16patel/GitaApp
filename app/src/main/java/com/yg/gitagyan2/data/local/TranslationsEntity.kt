package com.yg.gitagyan2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TranslationsEntity(
    var EN: String = ""  ,
    var HN: String = "",
    var SN: String? = "",
    @PrimaryKey val id: Int? = null
){
    companion object{
        val NO_OP = TranslationsEntity("", "","")
    }
}