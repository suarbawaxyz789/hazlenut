package com.example.hazelnut.ui.features.ninjas.driverapponly

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabel
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle

@Preview
@Composable
fun WaypointCardPreview() {
    Column {
        WaypointCard(
            address = "3 Changi South street 2, Singapore 837484",
            numOfDeliveryParcel = 11,
            numOfWaypoints = 2, numOfPickupParcel = 10,
        )
    }
}

@Composable
fun WaypointCard(
    address: String,
    numOfDeliveryParcel: Int? = null,
    numOfPickupParcel: Int? = null,
    numOfWaypoints: Int? = null,
) {
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
                style = AkiraTheme.typography.heading5.copy(
                    color = colors.gray1
                ),
            )

            Spacer(modifier = Modifier.height(spacings.spacingXs))

            Row {
                Row(modifier = Modifier.weight(1f)) {
                    if (numOfWaypoints != null) {
                        ItemWithCount(numOfItem = 1, iconRes = R.drawable.icon_l_th_flag)
                    }
                    if (numOfDeliveryParcel != null) {
                        ItemWithCount(numOfItem = 1, iconRes = R.drawable.icon_l_ph_flag)
                    }
                    if (numOfPickupParcel != null) {
                        ItemWithCount(numOfItem = 1, iconRes = R.drawable.icon_l_vn_flag)
                    }
                }

                Row {
                    /// TODO better way to pass label from param.
                    JobLabel(
                        tagStyle = JobLabelStyle.PRIOR,
                        modifier = Modifier.padding(end = spacings.spacingXxxs)
                    )
                    JobLabel(
                        tagStyle = JobLabelStyle.COD,
                        modifier = Modifier.padding(end = spacings.spacingXxxs)
                    )
                }
            }

        }
    }

}

@Composable
private fun ItemWithCount(numOfItem: Int, iconRes: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(spacings.spacingS, spacings.spacingS)
        )
        Spacer(modifier = Modifier.width(spacings.spacingXxxs))
        Text(
            text = numOfItem.toString(),
            style = AkiraTheme.typography.body2.copy(
                color = colors.gray1
            ),
            maxLines = 1,
        )
        Spacer(modifier = Modifier.width(spacings.spacingXs))
    }
}