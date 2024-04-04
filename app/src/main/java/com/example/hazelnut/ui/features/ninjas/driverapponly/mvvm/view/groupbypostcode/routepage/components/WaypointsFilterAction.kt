package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.component.list.ListItem
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointFilterUiState

@Preview
@Composable
private fun WaypointFilterActionPreview() {
    var uiState = WaypointFilterUiState(
        selectedTags = arrayListOf(),
        selectedJobTypes = arrayListOf(),
    )
//    WaypointsFilterAction(uiState)
}

@Composable
fun WaypointsFilterAction(
    uiState: WaypointFilterUiState,
    onFilterClick: (() -> Unit)?,
    onParcelStatusClick: (() -> Unit)?,
    onClose: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier
            .background(
                color = colors.white
            )
            .padding(
                start = spacings.spacingS,
                end = spacings.spacingS,
                top = spacings.spacingL
            )
    ) {
        Header(onClose = onClose)
        Spacer(modifier = Modifier.height(spacings.spacingL))
        Content(
            uiState = uiState,
            onFilterClick = onFilterClick,
            onParcelStatusClick = onParcelStatusClick,
        )
    }
}

@Composable
private fun Content(
    uiState: WaypointFilterUiState,
    onFilterClick: (() -> Unit)?,
    onParcelStatusClick: (() -> Unit)?,
) {
    Column {
        // not sure what index for
        ListItem(
            text = stringResource(id = R.string.filter),
            leftIconRes = R.drawable.icon_l_filter,
            index = 0,
            onClick = {
                onFilterClick?.invoke()
            },
            rightIconButtonRes = R.drawable.icon_l_angle_right
        )
        ListItem(
            text = stringResource(id = R.string.parcel_status),
            leftIconRes = R.drawable.icon_l_box,
            index = 0,
            onClick = {
                onParcelStatusClick?.invoke()
            },
            rightIconButtonRes = R.drawable.icon_l_angle_right
        )
    }
}


@Composable
private fun Header(
    onClose: (() -> Unit)?,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(id = R.string.actions),
            style = typography.heading6Bold.copy(
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
                modifier = Modifier.size(spacings.spacingS)
            )
        }
    }
}