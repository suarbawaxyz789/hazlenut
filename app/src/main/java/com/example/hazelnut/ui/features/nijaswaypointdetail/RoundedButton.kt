package com.example.hazelnut.ui.features.nijaswaypointdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hazelnut.R
import com.example.hazelnut.ui.theme.ninjas.TextView

@Preview
@Composable
fun RoundedButtonPreview() {
    RoundedButton(
        text = "A Button"
    )
}

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (() -> Unit)? = null,
    cornerRadius: Dp = 30.dp,
    elevation: Dp = 4.dp
) {
    Button(
        onClick = {
            onClick?.invoke()
        },
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(colorResource(id = R.color.primary))
            .height(IntrinsicSize.Min),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.primary)),
        elevation = ButtonDefaults.elevation(defaultElevation = elevation),
    ) {
        TextView.Bold(
            text = text, color = R.color.white, modifier = Modifier.padding(
                horizontal = 16.dp
            )
        )
    }
}
