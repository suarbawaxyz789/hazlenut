package com.example.hazelnut.ui.features.ninjas.akira.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors

@Composable
fun PrimaryLabelGrayButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    iconResId: Int? = null
) {
    BasePrimaryButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        containerColor = colors.gray2,
        pressedContainerColor = colors.gray1,
        contentColor = colors.white,
        isLoading = isLoading,
        iconResId = iconResId
    )
}
