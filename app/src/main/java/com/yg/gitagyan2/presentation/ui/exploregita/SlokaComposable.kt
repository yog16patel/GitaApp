package com.yg.gitagyan2.presentation.ui.exploregita

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yg.gitagyan2.R
import com.yg.gitagyan2.presentation.ui.TextComponent
import com.yg.gitagyan2.presentation.ui.setupscreens.GitaGyanViewModel
import com.yg.gitagyan2.presentation.ui.theme.SlokaBackgroundColor
import com.yg.gitagyan2.presentation.ui.theme.TextBlack

@Composable
fun SlokaComposable(
    gitaGyanViewModel: GitaGyanViewModel
) {
    val data = gitaGyanViewModel.chapterSlokas.value
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextComponent(
            text = data?.chapter_number.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )

        val paddingModifier = Modifier.padding(30.dp)
        Card(
            elevation = 10.dp,
            contentColor = TextBlack,
            modifier = paddingModifier,
            backgroundColor = SlokaBackgroundColor,
        ) {
            Box(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                TextComponent(
                    text = "",
                    modifier = Modifier.align(Alignment.TopCenter)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heartliked_icon),
                    contentDescription = "Liked",
                    modifier = Modifier.align(Alignment.TopEnd)
                )
                TextComponent(
                    text = " this is big thesflasdf asf;asdf a;sf ;asdf " +
                            "as asdfasdf adf asdfasd fasdfasd fasdf asdf " +
                            "asdf asdfasdfasd asdf asd asd fasdf " +
                            "asd asdfadsf asfas dfasdf asdf " +
                            "asdfasdfasdf asdfasdf asfasdf asfsd afasdf asdf " +
                            "asdfasdf asfas asdfas f",
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }
    }
}