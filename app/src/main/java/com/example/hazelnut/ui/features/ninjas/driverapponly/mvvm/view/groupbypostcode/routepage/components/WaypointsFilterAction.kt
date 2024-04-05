package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.component.list.ListItem
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointFilterUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.BottomSheetHeader

@Preview
@Composable
private fun WaypointFilterActionPreview() {
    var uiState = WaypointFilterUiState(
        selectedTags = arrayListOf(),
        selectedJobTypes = arrayListOf(),
        isHasActiveFilter = true
    )
    WaypointsFilterAction(uiState)
}

@Composable
fun WaypointsFilterAction(
    uiState: WaypointFilterUiState,
    onFilterClick: (() -> Unit)? = null,
    onParcelStatusClick: (() -> Unit)? = null,
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
        BottomSheetHeader(title = stringResource(id = R.string.actions), onClose = onClose)
        Spacer(modifier = Modifier.height(spacings.spacingL))
        Content(
            uiState = uiState,
            onFilterClick = onFilterClick,
            onParcelStatusClick = onParcelStatusClick,
        )
        Spacer(modifier = Modifier.height(spacings.spacingL))
    }
}

@Composable
private fun Content(
    uiState: WaypointFilterUiState,
    onFilterClick: (() -> Unit)?,
    onParcelStatusClick: (() -> Unit)?,
) {
    Column {
        ListItem(
            text = stringResource(id = R.string.filter),
            leftIconRes = if (uiState.isHasActiveFilter) R.drawable.icon_filtered_red_dot else R.drawable.icon_l_filter,
            index = 0,
            onClick = {
                onFilterClick?.invoke()
            },
            rightIconRes = R.drawable.icon_l_angle_right,
            hasBottomDivider = false
        )
        ListItem(
            text = stringResource(id = R.string.parcel_status),
            leftIconRes = R.drawable.icon_l_box,
            index = 0,
            onClick = {
                onParcelStatusClick?.invoke()
            },
            rightIconRes = R.drawable.icon_l_angle_right
        )
    }
}
