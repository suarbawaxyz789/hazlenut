package com.example.hazelnut.ui.theme.ninjas

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.hazelnut.R

object TextView {
    private val regular = FontFamily(Font(R.font.notosans_regular))
    private val bold = FontFamily(Font(R.font.notosans_bold))
    private val italic = FontFamily(Font(R.font.notosans_italic))
    private val neutralGrayColor = R.color.neutral_grey
    
    @Composable
    fun Regular(
        modifier: Modifier = Modifier,
        text: String,
        color: Int = neutralGrayColor,
        fontSize: TextUnit = 14.sp,
        textAlign: TextAlign = TextAlign.Start,
    ) {
        Text(
            modifier = modifier,
            text = text,
            textAlign = textAlign,
            color = colorResource(id = color),
            fontSize = fontSize,
            fontFamily = regular
        )
    }

    @Composable
    fun Bold(
        modifier: Modifier = Modifier,
        text: String,
        color: Int = neutralGrayColor,
        fontSize: TextUnit = 16.sp,
        textAlign: TextAlign = TextAlign.Start,
        letterSpacing: TextUnit = TextUnit.Unspecified
    ) {
        Text(
            modifier = modifier,
            text = text,
            textAlign = textAlign,
            color = colorResource(color),
            fontSize = fontSize,
            fontFamily = bold,
            letterSpacing = letterSpacing
        )
    }

    @Composable
    fun Italic(
        modifier: Modifier = Modifier,
        text: String,
        color: Int = neutralGrayColor,
        fontSize: TextUnit = 14.sp,
        textAlign: TextAlign = TextAlign.Start,
    ) {
        Text(
            modifier = modifier,
            text = text,
            textAlign = textAlign,
            color = colorResource(id = color),
            fontSize = fontSize,
            fontFamily = italic
        )
    }
}