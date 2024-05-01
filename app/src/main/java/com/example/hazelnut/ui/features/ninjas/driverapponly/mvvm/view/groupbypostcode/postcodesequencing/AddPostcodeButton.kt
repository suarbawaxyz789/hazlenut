package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.postcodesequencing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.component.button.ButtonTextLink
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostcodeSearchUiState

@Preview
@Composable
private fun AddPostcodeButtonPreview() {
    Column {
        AddPostcodeButton(location = WaypointToAddLocation.TOP)
        Divider()
        AddPostcodeButton(location = WaypointToAddLocation.BOTTOM)
        Divider()
        AddPostcodeButton(
            location = WaypointToAddLocation.BELOW_SELECTED_WAYPOINT,
            enabled = false,
        )
    }
}

enum class WaypointToAddLocation {
    TOP,
    BOTTOM,
    BELOW_SELECTED_WAYPOINT,
}

@Composable
fun AddPostcodeButton(
    location: WaypointToAddLocation,
    postcodeSearchUiState: PostcodeSearchUiState? = null,
    onClick: ((WaypointToAddLocation) -> Unit)? = null,
    enabled: Boolean = true,
) {
    if (postcodeSearchUiState?.isSearchPageActive == true) return
    val buttonText = when (location) {
        WaypointToAddLocation.TOP -> "Add postcodes to top"
        WaypointToAddLocation.BOTTOM -> "Add postcodes to bottom"
        WaypointToAddLocation.BELOW_SELECTED_WAYPOINT -> "Add postcodes"
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
            WaypointToAddLocation.BELOW_SELECTED_WAYPOINT, WaypointToAddLocation.TOP -> {
                Divider(
                    color = AkiraTheme.colors.gray7,
                )
            }
        }
    }
}