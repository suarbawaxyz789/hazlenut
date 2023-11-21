package com.example.hazelnut.ui.theme.ninjas

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.hazelnut.R

object Common {
    private val dividerColor = R.color.divider_color

    @Composable
    fun Divider(modifier: Modifier = Modifier) {
        Divider(
            modifier = modifier,
            color = colorResource(id = dividerColor),
            thickness = 1.dp
        )
    }
}