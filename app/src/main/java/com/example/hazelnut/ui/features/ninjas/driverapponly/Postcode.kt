package com.example.hazelnut.ui.features.ninjas.driverapponly

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.WaypointsGroupByPostcodeModel
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.WaypointModel
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.ItemWithCount
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.WaypointCard

@Preview
@Composable
private fun PostcodeCardPreview() {
    var sample1 = WaypointsGroupByPostcodeModel(
        numOfDelivery = 2,
        numOfPickup = 3,
        postcode = "12345",
        jobListData = listOf(
            WaypointModel(
                address = "1 Changi South street 2, Singapore 837484",
                jobListData = listOf(
                    Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111"))
                ),
                name = "Butterfly shop",
                enabled = true,
                jobTags = arrayListOf(
                    JobLabelStyle.PRIOR,
                    JobLabelStyle.COD,
                    JobLabelStyle.DOOR_STEP,
                    JobLabelStyle.ID_CHECK
                ),
            )
        )
    )

    WaypointsGroupByPostcode(sample1)
}

@Composable
fun WaypointsGroupByPostcode(
    waypointsGroupModel: WaypointsGroupByPostcodeModel
) {
    Column(modifier = Modifier.background(color = colors.gray9)) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = spacings.spacingS,
                )
                .padding(bottom = spacings.spacingXs, top = spacings.spacingM)
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
            waypointsGroupModel.jobListData.map { job ->
                WaypointCard(waypointModel = job)
            }
        }
    }
}