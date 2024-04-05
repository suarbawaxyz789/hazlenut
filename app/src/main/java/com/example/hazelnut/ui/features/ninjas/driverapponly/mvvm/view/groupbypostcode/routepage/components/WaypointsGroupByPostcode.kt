package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointCardUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointsGroupByPostcodeUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.ItemWithCount
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.WaypointCard

@Preview
@Composable
private fun WaypointsGroupByPostcodePreview() {
    var sampleMultiRTS: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.RTS, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
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
    waypointsGroupModel: WaypointsGroupByPostcodeUiState
) {
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