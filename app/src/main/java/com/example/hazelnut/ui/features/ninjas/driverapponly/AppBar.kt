package com.example.hazelnut.ui.features.ninjas.driverapponly

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors

@Composable
fun AppBarHeader(
    title: String,
    backButtonContent: (@Composable() () -> Unit)? = null,
    subtitleContent: (@Composable() () -> Unit)? = null,
    actions: List<Pair<Int, () -> Unit>> = emptyList()
) {
    val context = LocalContext.current
    Column {
        Row {
            if (backButtonContent != null) {
                backButtonContent()
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = AkiraTheme.typography.heading5.copy(
                        color = colors.gray1
                    ),
                    maxLines = 1,
                )
                if (subtitleContent != null) {
                    subtitleContent()
                }
            }
            Row {
                actions.forEach { (iconResourceId, onClickAction) ->
                    IconButton(onClick = {
                        onClickAction()
                    }) {
                        Icon(
                            painter = painterResource(id = iconResourceId),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}