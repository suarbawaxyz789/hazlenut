package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components

import android.app.Activity
import android.widget.Toast
import androidx.activity.ComponentActivity
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowCompat
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.bespoke.Legend
import com.example.hazelnut.ui.features.ninjas.bespoke.MultiColorProgressBar
import com.example.hazelnut.ui.features.ninjas.bespoke.ProgressType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.MultiColorProgressBarUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.AppBarHeader
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel.RouteWaypointsPostalcodeViewModel

@Composable
fun RoutePageAppBar(
    viewModel: RouteWaypointsPostalcodeViewModel,
    progressBarUiState: MultiColorProgressBarUiState
) {
    /// system status bar should follow appbar color
    val context = LocalContext.current
    if (context is ComponentActivity) {
        context.window.statusBarColor = AkiraTheme.colors.gray8.toArgb()
        WindowCompat.getInsetsController(context.window, context.window.decorView).apply {
            isAppearanceLightStatusBars = true
        }
    }

    val actions = listOf(
        R.drawable.icon_l_map_marker_alt to {
            Toast.makeText(context, "Map marker icon clicked", Toast.LENGTH_SHORT).show()
        },
        R.drawable.icon_l_envelope to {
            Toast.makeText(context, "Envelope icon clicked", Toast.LENGTH_SHORT).show()
            viewModel.test2()
        }
    )

    Box(modifier = Modifier.background(color = AkiraTheme.colors.gray8)) {
        Column(
            modifier = Modifier
                .padding(horizontal = AkiraTheme.spacings.spacingXxxs)
        ) {
            Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXxs))
            AppBarHeader(
                title = stringResource(id = R.string.route_title),
                backButtonContent = {
                    IconButton(onClick = {
                        if (context is Activity) {
                            context.finish()
                        }
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
                        text = stringResource(
                            id = R.string.route_id_number,
                            viewModel.routeId.collectAsState().value
                        ),
                        style = AkiraTheme.typography.body2.copy(
                            color = AkiraTheme.colors.gray3
                        ),
                        maxLines = 1,
                    )
                },
                actions = actions,
            )
            Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingS))
            AppBarProgressBar(uiState = progressBarUiState)
            Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXxs))
        }
    }
}

@Composable
fun AppBarProgressBar(uiState: MultiColorProgressBarUiState) {
    var expandedState = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AkiraTheme.spacings.spacingXxs)
    ) {
        MultiColorProgressBar(
            progresses = uiState.barValues.filter { it.type != ProgressType.NONE },
            state = expandedState,
            expandHeader = {
                Row {
                    Legend(barValue = uiState.barValues.first())
                }
            },
            expandContent = {
                Column {
                    uiState.barValues.map { Legend(barValue = it) }
                }
            }
        )
    }
}