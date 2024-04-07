package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointCardUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointsGroupByPostcodeUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.ItemWithCount
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.RectangleShimmer
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.WaypointCard

@Preview
@Composable
private fun WaypointsGroupByPostcodePreview() {
    val sampleMultiRTS: Map<JobType, List<String>> = mapOf(
        JobType.RTS to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
    )

    var tags = arrayListOf(
        JobLabelStyle.COD,
        JobLabelStyle.PRIOR,
        JobLabelStyle.DOOR_STEP,
        JobLabelStyle.ID_CHECK
    )

    var wpModel = WaypointCardUiState(
        address = "3 Changi South street 2, Singapore 837484",
        mapTIDByJobType = sampleMultiRTS,
        name = "Butterfly shop",
        enabled = true,
        jobTags = tags,
    )

    WaypointsGroupByPostcode(
        WaypointsGroupByPostcodeUiState(
            "123456",
            3,
            1,
            waypoints = listOf(wpModel)
        )
    )
}

@Composable
fun WaypointsGroupByPostcode(
    waypointsGroupModel: WaypointsGroupByPostcodeUiState,
    isShowShimmerLoading: Boolean = false,
) {
    if (isShowShimmerLoading) {
        WaypointCardShimmerLoading()
        return
    }
    Column(modifier = Modifier.background(color = AkiraTheme.colors.gray9)) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = AkiraTheme.spacings.spacingS,
                )
                .padding(
                    bottom = AkiraTheme.spacings.spacingXs,
                    top = AkiraTheme.spacings.spacingM
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = waypointsGroupModel.postcode,
                style = AkiraTheme.typography.heading6Bold,
                maxLines = 1,
                modifier = Modifier.weight(1f)
            )
            ItemWithCount(numOfItem = waypointsGroupModel.numOfDelivery, jobType = JobType.DELIVERY)
            ItemWithCount(numOfItem = waypointsGroupModel.numOfPickup, jobType = JobType.PICKUP)
        }
        Column {
            waypointsGroupModel.waypoints.map { job ->
                WaypointCard(waypointModel = job)
            }
        }
    }
}


@Composable
private fun WaypointCardShimmerLoading() {
    Column(modifier = Modifier.padding(horizontal = AkiraTheme.spacings.spacingS)) {
        Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingL))
        RectangleShimmer(
            modifier = Modifier
                .width(27.7.dp)
                .height(AkiraTheme.spacings.spacingXxs)
        )
        Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXs))
        RectangleShimmer(
            modifier = Modifier
                .height(AkiraTheme.spacings.spacingXxs)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingL))
        RectangleShimmer(
            modifier = Modifier
                .width(27.7.dp)
                .height(AkiraTheme.spacings.spacingXxs)
        )
        Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXs))
        RectangleShimmer(
            modifier = Modifier
                .height(AkiraTheme.spacings.spacingXxs)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingL))
        RectangleShimmer(
            modifier = Modifier
                .height(AkiraTheme.spacings.spacingXxs)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingL))
        Divider(
            color = AkiraTheme.colors.gray7,
        )
    }
}