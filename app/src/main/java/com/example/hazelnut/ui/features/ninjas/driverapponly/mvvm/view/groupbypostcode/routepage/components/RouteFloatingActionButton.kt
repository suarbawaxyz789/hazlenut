package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel.RouteWaypointsPostalcodeViewModel

@Preview
@Composable
private fun RouteFloatingActionPreview() {
    FloatingActionButton(
        backgroundColor = colors.gray2,
        onClick = {
            /// TODO
        },
        shape = CircleShape,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_l_action),
            contentDescription = null,
            tint = colors.white
        )
    }
}

@Composable
fun RouteFloatingActionButton(
    viewModel: RouteWaypointsPostalcodeViewModel,
) {
    Column {
        Box(
            modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.TopEnd
        ) {
            FloatingActionButton(
                backgroundColor = colors.gray2,
                onClick = {
                    viewModel.setFilterActionBottomSheetVisible(ModalBottomSheetValue.Expanded)
                },
                shape = CircleShape,
                modifier = Modifier.size(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_l_action),
                    contentDescription = null,
                    tint = colors.white
                )
            }
            if (viewModel.waypointsFilter.collectAsState().value.isHasActiveFilter) {
                Box(
                    modifier = Modifier.padding(
                        top = 2.dp,
                        end = 2.dp,
                    )
                ) {
                    Dot()
                }
            }

        }
    }
}

@Composable
fun Dot() {
    Box(
        modifier = Modifier
            .size(spacings.spacingXxs)
            .background(color = colors.red4, shape = CircleShape),
    )
}
