package com.yg.gitagyan2.presentation.ui.setupscreens.model

data class UserPreferences(
    var language: String = "",
    var currentProgress: String = "",
    var currentAdyah: Int = 0,
    var currentSloka: Int = 0,
    var likedSlokas: Int = 0
) {
    companion object {
        val NO_OP = UserPreferences("", "0%", 1, 1, 0)
    }
}
