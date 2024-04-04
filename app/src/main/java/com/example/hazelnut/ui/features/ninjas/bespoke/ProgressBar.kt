package com.example.hazelnut.ui.features.ninjas.bespoke

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.BarValueUiState

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ProgressBarPreview() {
    Column {
        ProgressBar(progress = 0F)
        Spacer(modifier = Modifier.height(10.dp))
        ProgressBar(progress = 0.2F)
        Spacer(modifier = Modifier.height(10.dp))
        ProgressBar(progress = 1F)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ProgressBarMultiColorPreview() {
    var progresses = arrayListOf(
        BarValueUiState(
            ProgressType.SUCCESS,
            progress = 0.1f,
            "15 successful waypoints",
        ),
        BarValueUiState(
            ProgressType.PENDING,
            progress = 0.1f, "54 pending waypoints",
        ),
        BarValueUiState(
            ProgressType.PARTIAL,
            progress = 0.1f, "1 partial waypoints",
        ),
        BarValueUiState(
            ProgressType.FAILED,
            progress = 0.2f, "1 partial waypoints",
        ),
        BarValueUiState(
            ProgressType.NONE,
            progress = 0.3f, "62 waypoints total",
        ),
    )

    var expandedState = remember {
        mutableStateOf(false)
    }

    Column {
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .width(300.dp)
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = "Without expandable",
                style = typography.body2.copy(
                    color = colors.gray2
                ),
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(spacings.spacingL))
            MultiColorProgressBar(
                progresses = progresses
            )
            Divider()
            Text(
                text = "With expandable content and header = ${expandedState.value}",
                style = typography.body2.copy(
                    color = colors.gray2
                ),
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(spacings.spacingL))
            MultiColorProgressBar(
                progresses = progresses,
                state = expandedState,
                expandHeader = {
                    Row {
                        Legend(barValue = progresses.first())
                    }
                },
                expandContent = {
                    Column {
                        progresses.map { Legend(barValue = it) }
                    }
                }
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
fun Legend(barValue: BarValueUiState) {
    val barColor = when (barValue.type) {
        ProgressType.SUCCESS -> colors.green3
        ProgressType.PENDING -> colors.gray3
        ProgressType.PARTIAL -> colors.orange3
        ProgressType.FAILED -> colors.red3
        ProgressType.NONE -> Color.Unspecified
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .background(color = barColor, shape = CircleShape)
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

@Composable
fun MultiColorProgressBar(
    progresses: List<BarValueUiState>,
    modifier: Modifier = Modifier,
    state: MutableState<Boolean>? = null,
    expandHeader: (@Composable() () -> Unit)? = null,
    expandContent: (@Composable() () -> Unit)? = null
) {
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
        if (expandHeader != null && expandContent != null && state != null) {
            Accordion(isExpanded = state.value,
                onExpandChanged = {
                    state.value = it
                },
                header = {
                    expandHeader()
                }, content = {
                    expandContent()
                }, onClick = {

                })
        }
    }
}


enum class ProgressType {
    SUCCESS,
    PENDING,
    PARTIAL,
    FAILED,
    NONE,
}

@Composable
fun MultiColorLinearProgressIndicatorBase(
    progresses: List<BarValueUiState>,
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {

    /// workaround for @Composable invocations can only happen from the context of a @Composable
    val red3 = colors.red3
    val green3 = colors.green3
    val orange3 = colors.orange3
    val gray3 = colors.gray3

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
            val barColor = when (it.type) {
                ProgressType.SUCCESS -> green3
                ProgressType.PENDING -> gray3
                ProgressType.PARTIAL -> orange3
                ProgressType.FAILED -> red3
                ProgressType.NONE -> Color.Unspecified
            }
            drawLinearIndicator(nextStart, nextStart + it.progress, barColor, strokeWidth)
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

@Composable
private fun Accordion(
    modifier: Modifier = Modifier,
    header: @Composable() () -> Unit,
    isExpanded: Boolean = false,
    onExpandChanged: (Boolean) -> Unit = {},
    shouldShowDivider: Boolean = false,
    content: @Composable() () -> Unit,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    val rotationState = if (isExpanded) 270f else 90f

    Column(
        modifier = modifier.then(
            Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = {
                        onExpandChanged(!isExpanded)
                        onClick()
                    }
                )
                .fillMaxWidth()
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = spacings.spacingXxs)
            ) {
                if (isExpanded) {
                    content()
                } else {
                    header()
                }
            }
            Icon(
                modifier = Modifier
                    .padding(
                        start = spacings.spacingXxs,
                        top = spacings.spacingXxs,
                        bottom = spacings.spacingXxs
                    )
                    .size(spacings.spacingXs)
                    .rotate(rotationState),
                painter = painterResource(id = R.drawable.angle_right),
                contentDescription = null
            )
        }

        if (shouldShowDivider) {
            Divider(
                color = colors.gray7,
                modifier = Modifier
                    .padding(
                        top = spacings.spacingXxs,
                        bottom = spacings.spacingXxs
                    )
            )
        }
    }
}