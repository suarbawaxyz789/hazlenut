package com.example.hazelnut.ui.features.ninjas.akira.chip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import com.example.hazelnut.R


@Composable
fun ChipChoice(
    text: String,
    modifier: Modifier = Modifier.width(80.dp),
    selected: Boolean = false,
    iconResId: Int,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Column(
        modifier = modifier
            .background(
                if (isPressed) colors.gray8 else colors.white,
                shape = RoundedCornerShape(AkiraTheme.spacings.spacingXxs)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick.invoke() }
            )
            .border(
                BorderStroke(
                    1.dp,
                    if (selected) colors.red3 else colors.gray7
                ),
                shape = RoundedCornerShape(AkiraTheme.spacings.spacingXxs)
            )
            .padding(all = AkiraTheme.spacings.spacingXxs)
    ) {
        Icon(
            modifier = Modifier
                .size(AkiraTheme.spacings.spacingS),
            painter = painterResource(id = iconResId),
            contentDescription = null
        )
        /// 15 on zeplin but give 10 to make bottom space become 10.
        Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXxs))
        /// on zeplin height is 20dp but text size 14sp with 20 line height is more than 20dp
        Text(
            text = text,
            style = AkiraTheme.typography.body2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}


@Composable
fun ChipFilter(
    text: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Row(
        modifier = modifier
            .background(if (isPressed) colors.gray8 else colors.white, shape = RoundedCornerShape(AkiraTheme.spacings.spacingXxs))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick.invoke() }
            )
            .border(
                BorderStroke(
                    1.dp,
                    if (selected) colors.red3 else colors.gray7
                ),
                shape = RoundedCornerShape(AkiraTheme.spacings.spacingXxs)
            )
            .height(AkiraTheme.spacings.spacingM)
            .padding(horizontal = AkiraTheme.spacings.spacingXxxs),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.padding(end = AkiraTheme.spacings.spacingXxxs),
            text = text,
            style = AkiraTheme.typography.body2,
            maxLines = 1,
        )
        Icon(
            modifier = Modifier
                .size(AkiraTheme.spacings.spacingXs),
            painter = painterResource(id = R.drawable.icon_l_times),
            contentDescription = null
        )
    }
}