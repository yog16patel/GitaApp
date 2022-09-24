package com.yg.gitagyan2.presentation.ui.common

import android.graphics.Color
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LongRoundedButtonWithText(
    modifier : Modifier = Modifier,
    text: String,
    onClick : () -> Unit,
    borderColor: Color,
    textColor: Color
) {
    TextButton(
        onClick = { onClick() }) {
        Text(
            text = text,
        )
    }
}