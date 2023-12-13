package com.example.hazelnut.ui.features.nijaswaypointdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.BottomSheet
import com.example.hazelnut.ui.theme.ninjas.TextView

@Composable
fun ParcelNotInWaypointDialog(
    onConfirmButtonClick: (() -> Unit)? = null,
    onDismiss: (() -> Unit)? = null,
    isVisible: Boolean = true,
) {
    BottomSheet(
        dialogTitle = stringResource(id = R.string.remove_parcel_dialog_title),
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
        primaryButtonText = "Scan Parcel before proces",
        isVisible = isVisible,
        onDismiss = {
            onDismiss?.invoke()
        },
        onPrimaryButtonClick = {
            onConfirmButtonClick?.invoke()
        }
    )
}