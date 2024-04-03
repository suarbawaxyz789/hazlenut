package com.example.hazelnut.ui.features.ninjas.akira.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import co.ninjavan.akira.designsystem.compose.foundation.NoRippleTheme

@Composable
fun BasePrimaryButton(
    text: String,
    containerColor: Color,
    pressedContainerColor: Color,
    contentColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    loadingColor: Color = colors.white,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    iconResId: Int? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val bgColorSelector = when {
        isLoading -> containerColor
        isPressed -> pressedContainerColor
        else -> containerColor
    }
    val disabledContainerColor = colors.gray7
    val padding =
        PaddingValues(
            start = spacings.spacingM,
            top = spacings.spacingXxs,
            end = spacings.spacingM,
            bottom = spacings.spacingXxs
        )
    var buttonSize by remember { mutableStateOf(DpSize.Zero) }
    val density = LocalDensity.current
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        ButtonWithoutRipple(
            onClick = {
                if (enabled && !isLoading) onClick()
            },
            modifier = modifier
                .then(Modifier.defaultMinSize(minWidth = 100.dp))
                .then(
                    if (buttonSize != DpSize.Zero) Modifier.size(buttonSize) else modifier
                )
                .onSizeChanged { newSize ->
                    if (buttonSize == DpSize.Zero) {
                        buttonSize = with(density) {
                            newSize
                                .toSize()
                                .toDpSize()
                        }
                    }
                },
            interactionSource = interactionSource,
            contentPadding = padding,
            enabled = enabled,
            containerColor = bgColorSelector,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = colors.gray4,
        ) {
            val loadingColorSelector = if (enabled) loadingColor else colors.gray4

            Box {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(spacings.spacingS).align(Alignment.Center),
                        color = loadingColorSelector,
                        strokeWidth = 2.dp,
                    )
                }

                Row(
                    modifier = Modifier.alpha(
                        if (isLoading) 0f else 1f
                    )
                ) {
                    iconResId?.let {
                        Icon(
                            modifier = Modifier
                                .size(spacings.spacingS)
                                .align(Alignment.CenterVertically),
                            painter = painterResource(id = it), contentDescription = ""
                        )
                        Spacer(modifier = Modifier.size(spacings.spacingXxxs, 0.dp))
                    }
                    Text(
                        modifier = Modifier.padding(0.dp),
                        text = text,
                        style = typography.body1
                    )
                }
            }
        }
    }
}
