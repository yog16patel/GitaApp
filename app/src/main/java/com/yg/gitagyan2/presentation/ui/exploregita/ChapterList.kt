package com.yg.gitagyan2.presentation.ui.exploregita

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yg.gitagyan2.domain.model.Chapter
import com.yg.gitagyan2.presentation.res.Dimensions
import com.yg.gitagyan2.presentation.ui.setupscreens.GitaGyanViewModel
import com.yg.gitagyan2.presentation.ui.theme.Bhagwa
import com.yg.gitagyan2.presentation.ui.theme.TextWhite
import com.yg.utils.fontFamily

@Composable
fun ChapterList(
    gitaGyanViewModel: GitaGyanViewModel,
    navigateToSlokaComposable: () -> Unit
) {

    val chaptersState = gitaGyanViewModel.chapterState
    Column {
        Text(
            text = "Adhyay",
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimensions.gitaPadding2x, horizontal = Dimensions.gitaPadding2x)
        )

        LazyColumn {
            items(chaptersState.size) { i ->
                val chapter = chaptersState[i]

                ChapterItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            gitaGyanViewModel.getSlokas()
                            navigateToSlokaComposable()
                        }
                        .padding(
                            vertical = Dimensions.gitaPadding,
                            horizontal = Dimensions.gitaPadding2x
                        ),
                    chapter
                )
            }
        }
    }

}

@Composable
fun ChapterItem(
    modifier: Modifier,
    chapter: Chapter
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(Bhagwa)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimensions.gitaPadding),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                text = "Chapter ${chapter.chapter_number}",
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = TextWhite,
                modifier = Modifier
                    .padding(
                        horizontal = Dimensions.gitaPadding2x,
                        vertical = Dimensions.gitaPaddingHalf
                    ),
            )
            Text(
                text = chapter.translations.EN,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = TextWhite,
                modifier = Modifier
                    .padding(
                        bottom = Dimensions.gitaPadding2x,
                        start = Dimensions.gitaPadding2x,
                        end = Dimensions.gitaPadding2x
                    )

            )
        }
    }
}