package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.postcodesequencing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.component.button.ButtonTextLink
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostalCodeSequencingActivityUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointToAddLocation

@Preview
@Composable
private fun AddPostcodeButtonPreview() {
    Column {
        AddPostcodeButton(location = WaypointToAddLocation.TOP)
        Divider()
        AddPostcodeButton(location = WaypointToAddLocation.BOTTOM)
        Divider()
        AddPostcodeButton(
            location = WaypointToAddLocation.MIDDLE,
        )
    }
}

@Composable
fun AddPostcodeButton(
    location: WaypointToAddLocation,
    uiState: PostalCodeSequencingActivityUiState? = null,
    onClick: ((WaypointToAddLocation) -> Unit)? = null,
) {
    if (uiState?.unsequencedPostcodesSearch?.isSearchPageActive == true) return

    // if no postcode sequenced, show only add waypoints (ADD_FOR_THE_FIRST_TIME)
    if (uiState?.sequencedPostcodesUiState?.isEmpty() == true && location != WaypointToAddLocation.ADD_FOR_THE_FIRST_TIME) {
        return
    }

    /// if all postcode sequenced, hide top, hide middle, shown bottom but disabled.
    var enabled = true
    if (uiState?.unsequencedPostcodesUiState?.isEmpty() == true) {
        if (location == WaypointToAddLocation.TOP) return
        if (location == WaypointToAddLocation.MIDDLE) return
        if (location == WaypointToAddLocation.BOTTOM) {
            enabled = false
        }
    }

    val buttonText = when (location) {
        WaypointToAddLocation.TOP -> stringResource(id = R.string.add_postcodes_to_top)
        WaypointToAddLocation.BOTTOM -> stringResource(id = R.string.add_postcodes_to_bottom)
        WaypointToAddLocation.MIDDLE -> stringResource(id = R.string.add_postcodes_to_middle)
        WaypointToAddLocation.ADD_FOR_THE_FIRST_TIME -> stringResource(id = R.string.add_postcodes_to_middle)
    }
    Column {
        Row(
            horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = spacings.spacingXxs,
                    bottom = spacings.spacingXxs,
                )
        ) {
            ButtonTextLink(text = buttonText, onClick = {
                onClick?.invoke(location)
            }, iconRes = R.drawable.icon_l_add, enabled = enabled)
        }
        when (location) {
            WaypointToAddLocation.BOTTOM -> {}
            WaypointToAddLocation.MIDDLE, WaypointToAddLocation.TOP -> {
                Divider(
                    color = colors.gray7,
                )
            }

            WaypointToAddLocation.ADD_FOR_THE_FIRST_TIME -> {}
        }
    }
}