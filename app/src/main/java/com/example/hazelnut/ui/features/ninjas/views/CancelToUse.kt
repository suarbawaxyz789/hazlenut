package com.example.hazelnut.ui.features.ninjas.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazelnut.R
import com.example.hazelnut.ui.theme.ninjas.TextView

/// TODO find the way to put 120 point based on percent of total points
@Composable
fun PointLinearProgressIndicator(
    progress: Float, backgroundColor: Color, indicatorColor: Color
) {
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
        LinearProgressIndicator(
            progress = progress,
            backgroundColor = backgroundColor,
            color = indicatorColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, end = 20.dp)
        )
        Row(
            modifier = Modifier
                .offset(y = -25.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f)
            ) {
                PointCircleSmall(point = 120, modifier = Modifier.offset(x = 100.dp))
            }
            PointCircleLarge(point = 300)
        }
        TextView.Regular(
            text = "64.6 Points",
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            color = R.color.neutral_grey,
            modifier = Modifier.offset(y = -63.dp),
        )
    }
}