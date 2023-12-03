package com.example.hazelnut.ui.features.nijaswaypointdetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazelnut.R
import com.example.hazelnut.ui.theme.ninjas.TextView

@Composable
@Preview
fun DialogStandardPreview() {
    BottomSheet(
        dialogTitle = stringResource(id = R.string.remove_parcel_dialog_title),
        desc = stringResource(id = R.string.remove_parcel_dialog_decs),
        buttonText = "Scan Parcel before proces",
        isVisible = true,
    )
}

@Composable
@Preview
fun DialogWithCustomContentPreview() {
    BottomSheet(
        dialogTitle = stringResource(id = R.string.remove_parcel_dialog_title),
        /// this should ignored.
        desc = stringResource(id = R.string.remove_parcel_dialog_decs),
        customContent = {
            Column {
                TextView.Regular(text = stringResource(id = R.string.remove_parcel_dialog_decs))
                Spacer(modifier = Modifier.height(16.dp))
                TextView.Bold(
                    text = LocalContext.current.getString(
                        R.string.dialog_tid,
                        "NVSGCTTDR000000837"
                    )
                )
            }
        },
        buttonText = "Scan Parcel before proces",
        isVisible = true,
    )
}

@Composable
fun BottomSheet(
    dialogTitle: String,
    desc: String? = null,
    buttonText: String,
    isVisible: Boolean = true,
    onDismiss: (() -> Unit)? = null,
    onConfirmButtonClick: (() -> Unit)? = null,
    /// use custom content, will ignore desc. but keep tittle
    customContent: @Composable (() -> Unit)? = null
) {
    if (isVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Black.copy(alpha = 0.5f) // Semi-transparent black
                )
                .clickable(onClick = {
                    onDismiss?.invoke()
                }),
            contentAlignment = Alignment.BottomCenter
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                elevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    TextView.Bold(text = dialogTitle)
                    Spacer(modifier = Modifier.height(16.dp))
                    if (customContent == null) {
                        if (desc != null) {
                            TextView.Regular(text = desc)
                        }
                    } else {
                        customContent()
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    RoundedButton(text = buttonText, onClick = {
                        onConfirmButtonClick?.invoke()
                    }, modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}
