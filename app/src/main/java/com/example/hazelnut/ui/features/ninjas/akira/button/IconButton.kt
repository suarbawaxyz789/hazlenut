package com.example.hazelnut.ui.features.ninjas.akira.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    iconRes: Int,
    onClick: (() -> Unit)? = null,
    cornerRadius: Dp = 50.dp,
    elevation: Dp = 4.dp,
    isEnabled: Boolean = true,
    isPressed: Boolean = false
) {
    Box(modifier = modifier) {
        OutlinedButton(
            onClick = {
                onClick?.invoke()
            },
            shape = RoundedCornerShape(cornerRadius),
            colors = ButtonDefaults.buttonColors(backgroundColor = if(!isPressed) colors.white else colors.gray8, disabledBackgroundColor = colors.white),
            elevation = ButtonDefaults.elevation(defaultElevation = elevation),
            border = BorderStroke(0.5.dp, if (!isEnabled) colors.gray4 else if (isPressed) colors.gray3 else colors.gray2),
            modifier = modifier.size(AkiraTheme.spacings.spacingXl),
            enabled = isEnabled
        ) {

        }
        Icon(
            modifier = Modifier
                .size(AkiraTheme.spacings.spacingS)
                .align(Alignment.Center),
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = if (!isEnabled) colors.gray4 else if (isPressed) colors.gray3 else colors.gray2
        )
    }
}
