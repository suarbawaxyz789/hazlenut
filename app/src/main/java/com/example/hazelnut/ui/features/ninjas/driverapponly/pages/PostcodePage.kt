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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.driverapponly.ItemWithCount
import com.example.hazelnut.ui.features.ninjas.driverapponly.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.groupbypostcode.components.AppBarHeader
import com.example.hazelnut.ui.features.ninjas.driverapponly.pages.samples.WaypointCardContentSample
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

/// POSTCODE PAGE IS NOT USED ANYMORE

/**
 * for postcode page
 */
@Preview(showBackground = true)
@Composable
fun Postcode3PagePreview() {
    PostcodePage()
}

@Composable
fun PostcodePage() {
    CollapsingToolbarScaffold(
        state = rememberCollapsingToolbarScaffoldState(),
        scrollStrategy = ScrollStrategy.EnterAlways,
        modifier = Modifier
            .fillMaxSize(),
        toolbar = {
            AppBarForPostcode()
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            WaypointCardContentSample()
        }
    }
}


@Composable
fun AppBarForPostcode() {
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
                title = "938494",
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
            Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXxs))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppBarParcelsCount(
                    numOfDeliveryParcel = 8,
                    numOfPickupParcel = 12,
                    numOfWaypoints = 18,
                )
            }
            Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXxs))
        }
    }
}

@Composable
fun AppBarParcelsCount(
    numOfDeliveryParcel: Int? = null,
    numOfPickupParcel: Int? = null,
    numOfWaypoints: Int? = null,
) {
    Row(modifier = Modifier.wrapContentWidth()) {
//        if (numOfWaypoints != null) {
//            ItemWithCount(
//                numOfItem = 1,
//                iconRes = R.drawable.icon_l_th_flag,
//            )
//        }
        if (numOfDeliveryParcel != null) {
            ItemWithCount(
                numOfItem = 1,
                jobType = JobType.DELIVERY
            )
        }
        if (numOfPickupParcel != null) {
            ItemWithCount(
                numOfItem = 1,
                jobType = JobType.PICKUP
            )
        }
    }
}