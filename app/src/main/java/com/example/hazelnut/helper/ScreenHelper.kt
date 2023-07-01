package com.example.hazelnut.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun calculatePaddingByHeight(percentage: Float): Dp {
    val screenHeight =
        LocalDensity.current.run { androidx.compose.ui.platform.LocalContext.current.resources.displayMetrics.heightPixels }
    val padding = screenHeight * percentage / 100
    return padding.dp
}


@Composable
fun calculatePaddingByWidth(percentage: Float): Dp {
    val screenWidth =
        LocalDensity.current.run { androidx.compose.ui.platform.LocalContext.current.resources.displayMetrics.widthPixels }
    val padding = screenWidth * percentage / 100
    return padding.dp
}