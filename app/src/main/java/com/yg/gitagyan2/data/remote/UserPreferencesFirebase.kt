package com.yg.gitagyan2.data.remote

data class UserPreferencesFirebase(
    var userId: String = "",
    var language: String = "",
    var currentProgress: String = "",
    var currentAdyah: Int = 0,
    var currentSloka: Int = 0,
    var likedSlokas: Int = 0
)
