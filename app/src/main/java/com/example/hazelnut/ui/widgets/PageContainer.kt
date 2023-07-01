package com.example.hazelnut.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hazelnut.helper.calculatePaddingByWidth

@Composable
fun PageContainer(
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier.padding(
            top = 50.dp,
            start = calculatePaddingByWidth(percentage = 2f),
            end = calculatePaddingByWidth(
                percentage = 2f
            )
        ),
        content = content,
    )
}