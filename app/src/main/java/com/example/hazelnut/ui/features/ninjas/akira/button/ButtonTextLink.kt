package com.example.hazelnut.ui.features.ninjas.akira.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography

/// NOTE  : this file are in akira. do not edit.

@Composable
fun ButtonTextLink(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconRes: Int? = null,
    iconRotation: Float = 0f,
    enabled: Boolean = true,
    isLoading: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val colorSelector = when {
        !enabled -> colors.gray4
        isLoading -> colors.red3
        isPressed -> colors.red2
        else -> colors.red3
    }
    Row(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                if (enabled && !isLoading) onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        iconRes?.apply {
            Icon(
                modifier = Modifier
                    .padding(
                        start = spacings.spacingXxxs,
                        end = spacings.spacingZero,
                        top = spacings.spacingZero,
                        bottom = spacings.spacingZero
                    )
                    .size(spacings.spacingXs)
                    .rotate(iconRotation),
                painter = painterResource(id = this),
                tint = colorSelector,
                contentDescription = null // decorative element
            )
        }
        Text(
            text = text,
            style = typography.body2Bold,
            color = colorSelector,
            modifier = Modifier.padding(
                start = if (iconRes != null) spacings.spacingXxxs else spacings.spacingZero,
                end = spacings.spacingXxxs,
                top = spacings.spacingZero,
                bottom = 2.dp,
            )
        )
        if (isLoading) {
            val loadingColorSelector = if (enabled) colors.gray5 else colors.gray4
            CircularProgressIndicator(
                modifier = Modifier
                    .size(spacings.spacingS)
                    .padding(start = spacings.spacingXxxs, top = 2.dp),
                color = loadingColorSelector,
                strokeWidth = 2.dp,
            )
        }
    }
}
