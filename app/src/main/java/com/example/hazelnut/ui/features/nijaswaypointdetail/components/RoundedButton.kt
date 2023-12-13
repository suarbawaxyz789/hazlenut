package com.example.hazelnut.ui.features.nijaswaypointdetail.components

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hazelnut.R
import com.example.hazelnut.ui.theme.ninjas.TextView

@VisibleForTesting
@Preview
@Composable
fun PrimaryButtonPreview() {
    RoundedButton(
        text = "A Button",
        buttonStyle = ButtonStyle.PRIMARY,
    )
}

@VisibleForTesting
@Preview
@Composable
fun PrimaryDisabledButtonPreview() {
    RoundedButton(
        text = "A Button",
        buttonStyle = ButtonStyle.PRIMARY_DISABLED,
    )
}


@VisibleForTesting
@Preview
@Composable
fun SecondaryButtonPreview() {
    RoundedButton(
        text = "A Button",
        buttonStyle = ButtonStyle.SECONDARY,
    )
}

@VisibleForTesting
@Preview
@Composable
fun DangerButtonPreview() {
    RoundedButton(
        text = "A Button",
        buttonStyle = ButtonStyle.SECONDARY_NEGATIVE,
    )
}

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (() -> Unit)? = null,
    cornerRadius: Dp = 30.dp,
    elevation: Dp = 4.dp,
    buttonStyle: ButtonStyle = ButtonStyle.PRIMARY,
) {
    var background: Int
    var strokeColor: Int
    var textColor: Int
    when (buttonStyle) {
        ButtonStyle.PRIMARY -> {
            background = R.color.primary
            strokeColor = R.color.primary
            textColor = R.color.text_color_white
        }

        ButtonStyle.SECONDARY -> {
            background = R.color.white
            strokeColor = R.color.primary
            textColor = R.color.primary
        }

        ButtonStyle.PRIMARY_DISABLED -> {
            background = R.color.divider_color
            strokeColor = R.color.divider_color
            textColor = R.color.color_b3b3b3
        }

        ButtonStyle.SECONDARY_NEGATIVE -> {
            background = R.color.white
            strokeColor = R.color.tab_color_red
            textColor = R.color.tab_color_red
        }
    }
    OutlinedButton(
        onClick = {
            onClick?.invoke()
        },
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = background)),
        elevation = ButtonDefaults.elevation(defaultElevation = elevation),
        border = BorderStroke(1.dp, colorResource(id = strokeColor)),
        modifier = modifier.fillMaxWidth()
    ) {
        TextView.Regular(
            text = text, color = textColor, modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                )
                .padding(top = 3.dp, bottom = 5.dp)
        )
    }
}

enum class ButtonStyle {
    PRIMARY, PRIMARY_DISABLED, SECONDARY, SECONDARY_NEGATIVE
}