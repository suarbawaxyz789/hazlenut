package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.bespoke.Legend
import com.example.hazelnut.ui.features.ninjas.bespoke.MultiColorProgressBar
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.AppBarHeader
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel.RouteWaypointsPostalcodeViewModel

@Composable
fun RoutePageAppBar(viewModel: RouteWaypointsPostalcodeViewModel) {
    val context = LocalContext.current
    val actions = listOf(
        R.drawable.icon_l_map_marker_alt to {
            Toast.makeText(context, "Map marker icon clicked", Toast.LENGTH_SHORT).show()
        },
        R.drawable.icon_l_envelope to {
            Toast.makeText(context, "Envelope icon clicked", Toast.LENGTH_SHORT).show()
        }
    )

    Box(modifier = Modifier.background(color = AkiraTheme.colors.gray8)) {
        Column(
            modifier = Modifier
                .padding(horizontal = AkiraTheme.spacings.spacingXxxs)
        ) {
            Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXxs))
            AppBarHeader(
                title = "Route",
                backButtonContent = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Navigation icon clicked", Toast.LENGTH_SHORT)
                            .show()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.angle_right),
                            contentDescription = null,
                            modifier = Modifier.rotate(180f)
                        )
                    }
                },
                subtitleContent = {
                    Text(
                        text = "Route ID ${viewModel.routeId.value}",
                        style = AkiraTheme.typography.body2.copy(
                            color = AkiraTheme.colors.gray3
                        ),
                        maxLines = 1,
                    )
                },
                actions = actions,
            )
            Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingS))
            AppBarProgressBar(viewModel = viewModel)
            Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXxs))
        }
    }
}

@Composable
fun AppBarProgressBar(viewModel: RouteWaypointsPostalcodeViewModel) {
    var expandedState = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        MultiColorProgressBar(
            progresses = viewModel.barValues.value,
            state = expandedState,
            expandHeader = {
                Row {
                    Legend(barValue = viewModel.barValues.value.first())
                }
            },
            expandContent = {
                Column {
                    viewModel.barValues.value.map { Legend(barValue = it) }
                }
            }
        )
    }
}