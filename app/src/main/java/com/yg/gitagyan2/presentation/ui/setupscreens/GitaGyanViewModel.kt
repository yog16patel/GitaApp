package com.yg.gitagyan2.presentation.ui.setupscreens

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yg.gitagyan2.domain.model.Chapter
import com.yg.gitagyan2.domain.model.GitaSlokasItem
import com.yg.gitagyan2.domain.repository.GitaGyanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitaGyanViewModel @Inject constructor(
    private val gitaGyanRepository: GitaGyanRepository
) : ViewModel() {

    var chapterState by mutableStateOf(listOf<Chapter>())
    var chapterSlokas: MutableState<GitaSlokasItem?> = mutableStateOf(null)

    init {
        viewModelScope.launch {
            gitaGyanRepository.getChapterNames().let {
                it.data?.let { list ->
                    chapterState = list
                }
            }
        }
    }

    fun getSlokas() {
        viewModelScope.launch {
            gitaGyanRepository.getChapterSlokas(1).let {
                it.data?.let { chapterSloka ->
                    Log.e("Yogesh",chapterSloka.toString())
                    chapterSlokas.value = chapterSloka
                }
            }
        }
    }
}