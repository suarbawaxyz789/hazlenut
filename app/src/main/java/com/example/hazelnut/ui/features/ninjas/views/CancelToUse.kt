package com.example.hazelnut.ui.features.ninjas.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.utils.StringUtil
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


@Composable
fun PointCircleSmall(
    modifier: Modifier = Modifier,
    point: Int,
) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(37.dp)
                    .border(
                        width = 2.dp, color = colorResource(id = R.color.white), shape = CircleShape
                    ),
            ) {
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .background(colorResource(id = R.color.indicator_thumb_yellow), CircleShape)
                        .padding(2.dp), contentAlignment = Alignment.Center
                ) {
                    TextView.Regular(
                        text = point.toString(),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        color = R.color.white
                    )
                }
            }
            TextView.Bold(
                text = LocalContext.current.getString(
                    R.string.prefix_rp_with_amount, StringUtil.getFormattedAmountInDouble(150000.0)
                ),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = R.color.neutral_grey,
            )
        }
    }
}


//@Preview
@Composable
fun PreviewCustomLinearProgress() {
    Column {
        PointLinearProgressIndicator(
            progress = 0.2f, backgroundColor = Color.Gray, indicatorColor = Color.Red
        )
    }
}