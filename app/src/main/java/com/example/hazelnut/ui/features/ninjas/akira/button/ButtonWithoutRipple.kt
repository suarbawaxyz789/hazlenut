package com.example.hazelnut.ui.features.ninjas.akira.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Surface
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ButtonElevation
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings

@Composable
fun ButtonWithoutRipple(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(25.dp),
    containerColor: Color,
    contentColor: Color,
    disabledContainerColor: Color,
    disabledContentColor: Color,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    val contentColorSelector = if (enabled) contentColor else disabledContentColor
    val containerColorSelector = if (enabled) containerColor else disabledContainerColor
    Surface(
        border = border,
        shape = shape
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColorSelector) {
            Row(
                modifier = modifier.then(
                    Modifier
                        .defaultMinSize(
                            minWidth = 100.dp,
                            minHeight = ButtonDefaults.MinHeight
                        )
                        .background(
                            color = containerColorSelector,
                            shape = shape
                        )
                        .padding(
                            start = spacings.spacingM,
                            end = spacings.spacingM,
                            top = spacings.spacingXxs,
                            bottom = spacings.spacingXxs,
                        )
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            onClick()
                        }),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                content()
            }
        }
    }
}
