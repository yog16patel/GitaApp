package com.yg.gitagyan2.domain.model

data class Translations(
    val EN: String = ""  ,
    val HN: String = "",
    val SN: String? = ""
){
    companion object{
        val NO_OP = Translations("", "","")
    }
}