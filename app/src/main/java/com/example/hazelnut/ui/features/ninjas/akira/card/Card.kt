package com.example.hazelnut.ui.features.ninjas.akira.card

import android.widget.Space
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.akira.button.ButtonTextLink

@Preview
@Composable
fun CardPreview() {
    Column {
        Card(
            header = "Header", text = "Helper text here, max line to 2 lines.",
            onClick = {

            },
            modifier = Modifier.width(180.dp)
        )
        Spacer(modifier = Modifier.height(spacings.spacingXxs))
        Card(
            header = "Header", text = "Helper text here, max line to 2 lines.",
            onClick = {

            },
            textLink = "Text Link",
            modifier = Modifier.width(180.dp)
        )
        Spacer(modifier = Modifier.height(spacings.spacingXxs))
        Card(
            header = "Header", text = "Helper text here, max line to 2 lines.",
            onClick = {

            },
            textLink = "Text Link",
            avatarRes = R.drawable.icon_l_th_flag,
            modifier = Modifier.width(250.dp)
        )
        Spacer(modifier = Modifier.height(spacings.spacingXxs))
        Card(
            header = "Header", text = "Helper text here, max line to 2 lines.",
            onClick = {

            },
            textLink = "Text Link",
            avatarRes = R.drawable.icon_l_th_flag,
            modifier = Modifier.width(250.dp),
            stackVertically = true,
        )
        Spacer(modifier = Modifier.height(spacings.spacingXxs))
    }
}


@Composable
fun Card(
    header: String,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    avatarRes: Int? = null,
    textLink: String? = null,
    stackVertically: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Row(
        modifier = modifier
            .background(
                if (isPressed) colors.gray8 else colors.white, shape = RoundedCornerShape(
                    spacings.spacingXxs
                )
            )
            .border(
                BorderStroke(
                    1.dp,
                    if (isPressed) colors.gray5 else colors.gray7
                ),
                shape = RoundedCornerShape(spacings.spacingXxs)
            )
            .padding(horizontal = spacings.spacingXxxs).run {
                if (textLink == null) {
                    this.clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = { onClick.invoke() }
                    )
                } else {
                    this
                }
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (stackVertically) {
            Column(
                modifier = Modifier.padding(
                    horizontal = spacings.spacingXxs,
                    vertical = spacings.spacingXs
                )
            ) {
                if (avatarRes != null) {
                    Icon(
                        painter = painterResource(id = avatarRes),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                    )
                    Spacer(modifier = Modifier.height(spacings.spacingS))
                }
                Column {
                    Text(
                        modifier = Modifier.padding(end = spacings.spacingXxxs),
                        text = header,
                        style = typography.body2Bold.copy(
                            color = colors.gray2,
                        ),
                        maxLines = 1,
                    )
                    Text(
                        modifier = Modifier.padding(end = spacings.spacingXxxs),
                        text = text,
                        style = typography.body2.copy(
                            color = colors.gray2,
                        ),
                        maxLines = 2,
                    )

                    if (textLink != null) {
                        Spacer(modifier = Modifier.height(spacings.spacingS))
                        ButtonTextLink(text = textLink, onClick = {
                            onClick.invoke()
                        })
                    }
                }
            }
        } else {
            Row(
                modifier = Modifier.padding(
                    horizontal = spacings.spacingXxs,
                    vertical = spacings.spacingXs
                )
            ) {
                if (avatarRes != null) {
                    Icon(
                        painter = painterResource(id = avatarRes),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                    )
                    Spacer(modifier = Modifier.width(spacings.spacingS))
                }
                Column {
                    Text(
                        modifier = Modifier.padding(end = spacings.spacingXxxs),
                        text = header,
                        style = typography.body2Bold.copy(
                            color = colors.gray2,
                        ),
                        maxLines = 1,
                    )
                    Text(
                        modifier = Modifier.padding(end = spacings.spacingXxxs),
                        text = text,
                        style = typography.body2.copy(
                            color = colors.gray2,
                        ),
                        maxLines = 2,
                    )

                    if (textLink != null) {
                        Spacer(modifier = Modifier.height(spacings.spacingS))
                        ButtonTextLink(text = textLink, onClick = {
                            onClick.invoke()
                        })
                    }
                }
            }
        }
    }
}