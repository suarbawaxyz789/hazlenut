package com.example.hazelnut.ui.features.akira_not_compatible

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit,
    placeHolder: String,
    backgroundColor: Color = AkiraTheme.colors.gray9,
    onLeftIconClick: ((String) -> Unit)? = null,
) {
    val currentText = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(50)
            ),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            modifier = Modifier
                .border(
                    BorderStroke(width = 1.dp, color = AkiraTheme.colors.gray9),
                    shape = RoundedCornerShape(50)
                )
                .fillMaxWidth(),
            textStyle = AkiraTheme.typography.body1,
            onValueChange = {
                currentText.value = it
                onTextChange.invoke(it)
            },
            value = currentText.value,
            placeholder = {
                Text(
                    text = placeHolder,
                    style = AkiraTheme.typography.body1.copy(
                        color = AkiraTheme.colors.gray3
                    ),
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Row(modifier = Modifier.padding(AkiraTheme.spacings.spacingXxxs)) {
                    IconButton(onClick = {
                        onLeftIconClick?.invoke(currentText.value)
                    }) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.icon_l_search
                            ),
                            contentDescription = null,
                            modifier = modifier.size(AkiraTheme.spacings.spacingS)
                        )
                    }
                }
            },
            trailingIcon = {
                Row(modifier = Modifier.padding(end = AkiraTheme.spacings.spacingXxxs)) {
                    IconButton(onClick = {
                        currentText.value = ""
                    }) {
                        if (currentText.value.isNotBlank()) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_l_times),
                                contentDescription = null,
                                modifier = modifier.size(AkiraTheme.spacings.spacingXs)
                            )
                        }
                    }
                }
            },
        )
    }
}
