package com.yg.gitagyan2.presentation.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.yg.utils.fontFamily

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight : FontWeight = FontWeight.Normal,
    fontSize : TextUnit = TextUnit.Unspecified,
    textAlign : TextAlign = TextAlign.Left
) {
    Text(
        text = text,
        modifier = modifier,
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight,
        textAlign = textAlign
    )
}
