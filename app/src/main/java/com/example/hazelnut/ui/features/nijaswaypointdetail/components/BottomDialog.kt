package com.example.hazelnut.ui.features.nijaswaypointdetail.components

import androidx.annotation.VisibleForTesting
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

//@VisibleForTesting
//@Composable
//@Preview
//fun DialogConfirmSequenceSuggestionPreview() {
//    BottomSheet(
//        dialogTitle = stringResource(id = R.string.use_past_sequence_dialog_title),
//        primaryButtonStyle = ButtonStyle.SECONDARY,
//        primaryButtonText = stringResource(id = R.string.create_new_sequence),
//        onPrimaryButtonClick = {
//
//        },
//        secondaryButtonText = stringResource(id = R.string.use_past_sequence),
//        secondaryButtonStyle = ButtonStyle.PRIMARY,
//        onSecondaryButtonClick = {
//
//        },
//        isVisible = true,
//    )
//}

@VisibleForTesting
@Composable
@Preview
fun DialogLeaveWithExistingScansPreview() {
    BottomSheet(
        dialogTitle = stringResource(id = R.string.leave_with_existing_scans),
        /// this should ignored. not sure this good practice or not.
        desc = stringResource(id = R.string.you_have_registered_parcels_in_this_waypoint),
        primaryButtonText = stringResource(id = R.string.back_to_waypoint),

        secondaryButtonText = stringResource(id = R.string.exit_to_route_list),
        onSecondaryButtonClick = {

        },
        onPrimaryButtonClick = {

        },
        isVisible = true,
    )
}

@VisibleForTesting
@Composable
@Preview
fun DialogStandardPreview() {
    BottomSheet(
        dialogTitle = stringResource(id = R.string.remove_parcel_dialog_title),
        desc = stringResource(id = R.string.remove_parcel_dialog_decs),
        primaryButtonText = "Scan Parcel before proces",
        isVisible = true,
    )
}

@VisibleForTesting
@Composable
@Preview
fun DialogWithCustomContentPreview() {
    BottomSheet(
        dialogTitle = stringResource(id = R.string.remove_parcel_dialog_title),
        /// this should ignored. not sure this good practice or not.
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
        primaryButtonText = "Scan Parcel before proces",
        isVisible = true,
    )
}


@Composable
fun BottomSheet(
    dialogTitle: String,
    desc: String? = null,
    isVisible: Boolean = true,
    onDismiss: (() -> Unit)? = null,
    /// use custom content, will ignore desc. but keep title and buttons
    customContent: @Composable (() -> Unit)? = null,
    primaryButtonText: String,
    primaryButtonStyle: ButtonStyle = ButtonStyle.PRIMARY,
    onPrimaryButtonClick: (() -> Unit)? = null,
    /// secondary button will shown if callback and string not empty or null.
    secondaryButtonText: String = "",
    secondaryButtonStyle: ButtonStyle = ButtonStyle.SECONDARY,
    onSecondaryButtonClick: (() -> Unit)? = null,
) {
    if (isVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Black.copy(alpha = 0.5f)
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
                        .fillMaxWidth()
                ) {
                    TextView.Bold(text = dialogTitle)
                    Spacer(modifier = Modifier.height(16.dp))
                    if (customContent == null) {
                        if (desc != null) {
                            TextView.Regular(
                                text = desc,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    } else {
                        customContent()

                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    if (secondaryButtonText.isNotEmpty() && onSecondaryButtonClick != null) {
                        RoundedButton(
                            text = secondaryButtonText,
                            onClick = {
                                onSecondaryButtonClick.invoke()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            buttonStyle = secondaryButtonStyle,
                        )
                    }
                    RoundedButton(
                        text = primaryButtonText,
                        onClick = {
                            onPrimaryButtonClick?.invoke()
                        },
                        modifier = Modifier.fillMaxWidth(), buttonStyle = primaryButtonStyle,
                    )

                }
            }
        }
    }
}
