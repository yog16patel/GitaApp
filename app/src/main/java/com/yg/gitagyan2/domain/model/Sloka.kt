package com.yg.gitagyan2.domain.model


import com.google.gson.annotations.SerializedName

data class Sloka(
    @SerializedName("isFavorite")
    var isFavorite: Boolean = false,
    @SerializedName("number")
    var number: Int = 0,
    @SerializedName("sanskrit")
    var sanskrit: String = "",
    @SerializedName("translations")
    var translations: Translations = Translations.NO_OP
)