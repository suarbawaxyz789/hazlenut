package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import com.example.hazelnut.R

@Composable
fun BottomSheetHeader(
    title : String,
    onClose: (() -> Unit)?,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = title,
            style = AkiraTheme.typography.heading6Bold.copy(
                color = colors.gray2
            ),
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = {
            onClose?.invoke()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.icon_l_times),
                contentDescription = null,
                modifier = Modifier.size(AkiraTheme.spacings.spacingS)
            )
        }
    }
}