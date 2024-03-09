package com.example.hazelnut.ui.features.ninjas.bespoke

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography

@Preview
@Composable
fun testPreview() {
    Column {
        ProgressBar(progress = 0F)
        Spacer(modifier = Modifier.height(10.dp))
        ProgressBar(progress = 0.2F)
        Spacer(modifier = Modifier.height(10.dp))
        ProgressBar(progress = 1F)
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier
            .width(300.dp)
            .padding(horizontal = 10.dp)) {
            MultiColorProgressBar(
                progresses = arrayListOf(
                    BarValue(
                        colors.red3,
                        progress = 0.1f,
                        "15 successful waypoints",
                    ),
                    BarValue(
                        colors.green3,
                        progress = 0.1f, "54 pending waypoints",
                    ),
                    BarValue(
                        colors.orange3,
                        progress = 0.1f, "1 partial waypoints",
                    ),
                    BarValue(
                        colors.gray3,
                        progress = 0.2f, "short 1",
                    ),
                    BarValue(
                        colors.blue3,
                        progress = 0.3f, "short",
                    ),
                )
            )
        }

    }
}

@Composable
fun ProgressBar(progress: Float, modifier: Modifier = Modifier) {
    LinearProgressIndicator(
        modifier = modifier
            .background(
                colors.blue1,
                shape = RoundedCornerShape(spacings.spacingXxs)
            )
            .clip(CircleShape)
            .height(spacings.spacingXxxs),
        color = colors.red3,
        progress = progress,
        backgroundColor = colors.gray7
    )
}

@Composable
fun Legend(barValue: BarValue) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .background(color = barValue.color, shape = CircleShape)
                .width(spacings.spacingXxs)
                .height(spacings.spacingXxs)
        )
        Spacer(modifier = Modifier.width(spacings.spacingXxxs))
        Text(
            text = barValue.legend,
            style = typography.body2.copy(
                color = colors.gray2
            ),
            maxLines = 1,
        )
        Spacer(modifier = Modifier.width(spacings.spacingS))
    }
}

private val LinearIndicatorWidth = 240.dp
private val LinearIndicatorHeight = ProgressIndicatorDefaults.StrokeWidth

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MultiColorProgressBar(progresses: List<BarValue>, modifier: Modifier = Modifier) {
    Column {
        MultiColorLinearProgressIndicatorBase(
            modifier = modifier
                .background(
                    colors.gray7,
                    shape = RoundedCornerShape(spacings.spacingXxs)
                )
                .clip(CircleShape)
                .height(spacings.spacingXxxs)
                .fillMaxWidth(),
            progresses = progresses,
            backgroundColor = colors.gray7,
        )
        Spacer(modifier = Modifier.height(spacings.spacingXxs))
        FlowRow {
            progresses.map { Legend(barValue = it) }
        }
    }
}

class BarValue(color: Color, progress: Float, legend: String) {
    var color: Color = color
    var progress: Float = progress
    var legend: String = legend
}

@Composable
fun MultiColorLinearProgressIndicatorBase(
    progresses: List<BarValue>,
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {
    androidx.compose.foundation.Canvas(
        modifier
            .progressSemantics(
                progresses
                    .map { it.progress }
                    .reduce { acc, barValue -> acc + barValue })
            .size(LinearIndicatorWidth, LinearIndicatorHeight)
    ) {
        val strokeWidth = size.height

        drawLinearIndicatorBackground(backgroundColor, strokeWidth)

        var nextStart = 0f

        progresses.map {
            drawLinearIndicator(nextStart, nextStart + it.progress, it.color, strokeWidth)
            nextStart += it.progress
        }
    }
}

private fun DrawScope.drawLinearIndicatorBackground(
    color: Color,
    strokeWidth: Float
) = drawLinearIndicator(0f, 1f, color, strokeWidth)

private fun DrawScope.drawLinearIndicator(
    startFraction: Float,
    endFraction: Float,
    color: Color,
    strokeWidth: Float
) {
    val width = size.width
    val height = size.height
    // Start drawing from the vertical center of the stroke
    val yOffset = height / 2

    val isLtr = layoutDirection == LayoutDirection.Ltr
    val barStart = (if (isLtr) startFraction else 1f - endFraction) * width
    val barEnd = (if (isLtr) endFraction else 1f - startFraction) * width

    // Progress line
    drawLine(color, Offset(barStart, yOffset), Offset(barEnd, yOffset), strokeWidth)
}
