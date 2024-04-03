package com.example.hazelnut.ui.features.ninjas.driverapponly

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabel
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.ItemWithCount

//// POSTCARD IS NOT USED ANYMORE
@Preview
@Composable
fun PostCardPreview() {
    Column {
        PostCard(
            address = "3 Changi South street 2, Singapore 837484",
            numOfDeliveryParcel = 11,
            numOfWaypoints = 2, numOfPickupParcel = 10,
        )
        Spacer(modifier = Modifier.height(spacings.spacingM))
        PostCard(
            address = "3 Changi South street 2, Singapore 837484",
            numOfDeliveryParcel = 11,
            numOfWaypoints = 2, numOfPickupParcel = 10,
            enable = false
        )
        Spacer(modifier = Modifier.height(spacings.spacingM))
        PostCard(
            address = "3 Changi South street 2, Singapore 837484",
            numOfDeliveryParcel = 11,
            numOfWaypoints = 2, numOfPickupParcel = 10,
            enable = false,
            name = "Buttefly shop"
        )
    }
}

@Composable
fun PostCard(
    address: String,
    numOfDeliveryParcel: Int? = null,
    numOfPickupParcel: Int? = null,
    numOfWaypoints: Int? = null,
    enable: Boolean = true,
    name: String? = null,
) {
    Column {
        Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXxs))
        Box(
            modifier = Modifier
                .background(color = colors.white)
        ) {
            Column(
                modifier = Modifier
                    .padding(all = spacings.spacingS)
            ) {
                Text(
                    text = address,
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) colors.gray1 else colors.gray6
                    ),
                )

                Spacer(modifier = Modifier.height(spacings.spacingXs))

                Row {
                    Row(modifier = Modifier.weight(1f)) {
//                        if (numOfWaypoints != null) {
//                            ItemWithCount(
//                                numOfItem = 1,
//                                iconRes = R.drawable.icon_l_th_flag,
//                                enable = enable
//                            )
//                        }
                        if (numOfDeliveryParcel != null) {
                            ItemWithCount(
                                numOfItem = 1,
                                jobType = JobType.DELIVERY,
                                enable = enable
                            )
                        }
                        if (numOfPickupParcel != null) {
                            ItemWithCount(
                                numOfItem = 1,
                                jobType = JobType.PICKUP,
                                enable = enable
                            )
                        }
                    }

                    Row {
                        /// TODO better way to pass label from param.
                        JobLabel(
                            tagStyle = JobLabelStyle.PRIOR,
                            modifier = Modifier.padding(end = spacings.spacingXxxs),
                            enable = enable,
                        )
                        JobLabel(
                            tagStyle = JobLabelStyle.COD,
                            modifier = Modifier.padding(end = spacings.spacingXxxs),
                            enable = enable,
                        )
                    }
                }
            }
        }
    }
}