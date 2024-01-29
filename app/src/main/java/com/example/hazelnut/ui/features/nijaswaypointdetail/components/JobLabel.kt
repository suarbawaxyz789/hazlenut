package com.example.hazelnut.ui.features.nijaswaypointdetail.components

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazelnut.R
import com.example.hazelnut.ui.theme.ninjas.TextView

@VisibleForTesting
@Preview
@Composable
fun JobLabelDelivery() {
    JobLabel(
        text = "Delivery",
        tagStyle = JobLabelStyle.DELIVERY,
    )
}

@VisibleForTesting
@Preview
@Composable
fun JobLabelRPU() {
    JobLabel(
        text = "RPU",
        tagStyle = JobLabelStyle.RPU,
    )
}

@VisibleForTesting
@Preview
@Composable
fun JobLabelPRIOR() {
    JobLabel(
        text = "PRIOR",
        tagStyle = JobLabelStyle.PRIOR,
    )
}

@Composable
fun JobLabel(
    modifier: Modifier = Modifier,
    text: String,
    cornerRadius: Dp = 5.dp,
    tagStyle: JobLabelStyle = JobLabelStyle.DELIVERY,
) {
    var background: Int
    var strokeColor: Int
    var textColor: Int

    when (tagStyle) {
        JobLabelStyle.DELIVERY -> {
            background = R.color.waypoint_partial_success
            strokeColor = R.color.indicator_orange
            textColor = R.color.indicator_orange
        }

        JobLabelStyle.PRIOR -> {
            background = R.color.prior_tag_background
            strokeColor = R.color.prior_tag_background
            textColor = R.color.text_color_white
        }

        JobLabelStyle.RPU -> {
            background = R.color.rpu_tag_background
            strokeColor = R.color.rpu_tag_border
            textColor = R.color.rpu_tag_border
        }
    }

    Box(
        modifier = modifier
            .background(
                color = colorResource(id = background),
                shape = RoundedCornerShape(cornerRadius)
            )
            .border(1.dp, colorResource(id = strokeColor), shape = RoundedCornerShape(cornerRadius))
    ) {
        TextView.Bold(
            text = text, fontSize = 12.sp, color = textColor, modifier = Modifier
                .padding(
                    horizontal = 10.dp,
                )
                .padding(top = 0.dp, bottom = 2.dp)
        )
    }
}

enum class JobLabelStyle {
    DELIVERY, RPU, PRIOR
}