package com.example.hazelnut.ui.features.nijaswaypointdetail.components

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R

@VisibleForTesting
@Preview
@Composable
private fun JobLabelPreview() {
    Column {
        JobLabel(
            tagStyle = JobLabelStyle.DELIVERY,
        )
        Spacer(modifier = Modifier.height(8.dp))
        JobLabel(
            tagStyle = JobLabelStyle.RPU,
        )
        Spacer(modifier = Modifier.height(8.dp))
        JobLabel(
            tagStyle = JobLabelStyle.PRIOR,
        )
        Spacer(modifier = Modifier.height(8.dp))
        JobLabel(
            tagStyle = JobLabelStyle.COD,
        )
        Spacer(modifier = Modifier.height(8.dp))
        JobLabel(
            tagStyle = JobLabelStyle.CONFIRMED,
        )
        Spacer(modifier = Modifier.height(8.dp))
        JobLabel(
            tagStyle = JobLabelStyle.DOOR_STEP,
        )
        Spacer(modifier = Modifier.height(8.dp))
        JobLabel(
            tagStyle = JobLabelStyle.ID_CHECK,
        )
        Spacer(modifier = Modifier.height(8.dp))
        JobLabel(
            tagStyle = JobLabelStyle.OPEN_BOX,
        )
        Spacer(modifier = Modifier.height(8.dp))
        JobLabel(
            tagStyle = JobLabelStyle.OPEN_BOX,
            enable = false,
        )
    }
}

@Composable
fun JobLabel(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = AkiraTheme.spacings.spacingXxxs,
    tagStyle: JobLabelStyle = JobLabelStyle.DELIVERY,
    enable: Boolean = true,
) {
    val tagName = when (tagStyle) {
        JobLabelStyle.DELIVERY -> stringResource(id = R.string.tag_delivery)
        JobLabelStyle.RPU -> stringResource(id = R.string.text_rpu_tag)
        JobLabelStyle.PRIOR -> stringResource(id = R.string.tag_prior)
        JobLabelStyle.COD -> stringResource(id = R.string.tag_cod)
        JobLabelStyle.CONFIRMED -> stringResource(id = R.string.tag_confirmed)
        JobLabelStyle.DOOR_STEP -> stringResource(id = R.string.tag_doorstep)
        JobLabelStyle.ID_CHECK -> stringResource(id = R.string.tag_id_check)
        JobLabelStyle.OPEN_BOX ->stringResource(id = R.string.tag_open_box)
    }

    val backgroundColor: Color =
        when (tagStyle) {
            JobLabelStyle.COD -> AkiraTheme.colors.red3
            JobLabelStyle.CONFIRMED -> AkiraTheme.colors.green1
            JobLabelStyle.DOOR_STEP -> AkiraTheme.colors.orange1
            JobLabelStyle.ID_CHECK -> AkiraTheme.colors.blue2
            JobLabelStyle.OPEN_BOX -> AkiraTheme.colors.yellow4
            JobLabelStyle.PRIOR -> AkiraTheme.colors.purple3
            JobLabelStyle.DELIVERY -> AkiraTheme.colors.orange6
            JobLabelStyle.RPU -> AkiraTheme.colors.purple6
        }

    val textColor =
        when (tagStyle) {
            JobLabelStyle.COD -> AkiraTheme.colors.white
            JobLabelStyle.CONFIRMED -> AkiraTheme.colors.white
            JobLabelStyle.DOOR_STEP -> AkiraTheme.colors.white
            JobLabelStyle.ID_CHECK -> AkiraTheme.colors.white
            JobLabelStyle.OPEN_BOX -> AkiraTheme.colors.gray2
            JobLabelStyle.PRIOR -> AkiraTheme.colors.white
            JobLabelStyle.DELIVERY -> AkiraTheme.colors.orange4
            JobLabelStyle.RPU -> AkiraTheme.colors.purple3
        }

    var strokeColor = when (tagStyle) {
        JobLabelStyle.DELIVERY -> AkiraTheme.colors.orange4
        JobLabelStyle.RPU -> AkiraTheme.colors.purple3
        else -> {
            backgroundColor
        }
    }

    var labelWidth: Dp? = when (tagStyle) {
        JobLabelStyle.RPU -> 50.dp
        else -> {
            null
        }
    }

    var labelHeight: Dp? = when (tagStyle) {
        JobLabelStyle.RPU -> 22.dp
        else -> {
            null
        }
    }

    var textStyle = when (tagStyle) {
        JobLabelStyle.RPU -> AkiraTheme.typography.body2.copy(
            fontWeight = FontWeight.Medium,
            color = if (enable) textColor else AkiraTheme.colors.white,
            fontFamily = FontFamily.SansSerif,
        )

        else -> {
            AkiraTheme.typography.body2.copy(
                lineHeight = 18.sp,
                color = if (enable) textColor else AkiraTheme.colors.white
            )
        }
    }

    Box(
        modifier = modifier
            .let { tempModifier ->
                if (labelWidth != null && labelHeight != null) {
                    tempModifier
                        .width(labelWidth)
                        .height(labelHeight)
                } else if (labelWidth != null) {
                    tempModifier.width(labelWidth)
                } else if (labelHeight != null) {
                    tempModifier.height(labelHeight)
                } else {
                    tempModifier.wrapContentSize()
                }
            }
            .background(
                color = if (enable) backgroundColor else AkiraTheme.colors.gray5,
                shape = RoundedCornerShape(cornerRadius)
            )
            .border(
                1.dp,
                if (enable) strokeColor else AkiraTheme.colors.gray5,
                shape = RoundedCornerShape(cornerRadius)
            )
    ) {
        Text(
            modifier = Modifier
                .padding(
                    horizontal = AkiraTheme.spacings.spacingXxs,
                )
                .align(Alignment.Center),
            text = tagName,
            style = textStyle
        )
    }
}

enum class JobLabelStyle {
    DELIVERY, RPU, PRIOR, COD,
    CONFIRMED,
    DOOR_STEP,
    ID_CHECK,
    OPEN_BOX,
}