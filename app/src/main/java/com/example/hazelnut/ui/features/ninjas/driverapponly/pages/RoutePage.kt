package com.example.hazelnut.ui.features.ninjas.driverapponly.pages

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.bespoke.BarValue
import com.example.hazelnut.ui.features.ninjas.bespoke.Legend
import com.example.hazelnut.ui.features.ninjas.bespoke.MultiColorProgressBar
import com.example.hazelnut.ui.features.ninjas.driverapponly.AppBarHeader
import com.example.hazelnut.ui.features.ninjas.driverapponly.pages.samples.PostCodeContentSample
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState


/**
 * for route page
 */
@Preview(showBackground = true)
@Composable
fun RoutePagePreview() {
    RoutePage()
}

@Composable
fun RoutePage() {
    CollapsingToolbarScaffold(
        state = rememberCollapsingToolbarScaffoldState(),
        scrollStrategy = ScrollStrategy.EnterAlways,
        modifier = Modifier
            .fillMaxSize(),
        toolbar = {
            AppBarForRoute()
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            PostCodeContentSample()
        }
    }
}

@Composable
fun AppBarForRoute() {
    val context = LocalContext.current
    val actions = listOf(
        R.drawable.icon_l_map_marker_alt to {
            Toast.makeText(context, "Map marker icon clicked", Toast.LENGTH_SHORT).show()
        },
        R.drawable.icon_l_envelope to {
            Toast.makeText(context, "Envelope icon clicked", Toast.LENGTH_SHORT).show()
        }
    )

    Box(modifier = Modifier.background(color = AkiraTheme.colors.gray9)) {
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
                            painter = painterResource(id = R.drawable.expanable_arrow_up),
                            contentDescription = null,
                            modifier = Modifier.rotate(270f)
                        )
                    }
                },
                subtitleContent = {
                    Text(
                        text = "Route ID 132434",
                        style = AkiraTheme.typography.body2.copy(
                            color = AkiraTheme.colors.gray3
                        ),
                        maxLines = 1,
                    )
                },
                actions = actions,
            )
            Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingS))
            AppBarProgressBar()
            Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXxs))
        }
    }
}

@Composable
fun AppBarProgressBar() {
    // this should come from view model.
    var progresses = arrayListOf(
        BarValue(
            AkiraTheme.colors.red3,
            progress = 0.1f,
            "15 successful waypoints",
        ),
        BarValue(
            AkiraTheme.colors.green3,
            progress = 0.1f, "54 pending waypoints",
        ),
        BarValue(
            AkiraTheme.colors.orange3,
            progress = 0.1f, "1 partial waypoints",
        ),
        BarValue(
            AkiraTheme.colors.gray3,
            progress = 0.2f, "short 1",
        ),
        BarValue(
            AkiraTheme.colors.blue3,
            progress = 0.3f, "short",
        ),
    )

    var expandedState = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        MultiColorProgressBar(
            progresses = arrayListOf(
                BarValue(
                    AkiraTheme.colors.red3,
                    progress = 0.1f,
                    "15 successful waypoints",
                ),
                BarValue(
                    AkiraTheme.colors.green3,
                    progress = 0.1f, "54 pending waypoints",
                ),
                BarValue(
                    AkiraTheme.colors.orange3,
                    progress = 0.1f, "1 partial waypoints",
                ),
                BarValue(
                    AkiraTheme.colors.gray3,
                    progress = 0.2f, "short 1",
                ),
                BarValue(
                    AkiraTheme.colors.blue3,
                    progress = 0.3f, "short",
                ),
            ),
            state = expandedState,
            expandHeader = {
                Row {
                    Legend(barValue = progresses.first())
                }
            },
            expandContent = {
                Column {
                    progresses.map { Legend(barValue = it) }
                }
            }
        )
    }
}