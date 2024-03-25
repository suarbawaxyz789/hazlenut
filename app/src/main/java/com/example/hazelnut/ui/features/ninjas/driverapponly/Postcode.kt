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

@Preview
@Composable
private fun PostcodeCardPreview() {
    /// 1 job 1 parcel
    var sample1: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111"))
    )

    PostcodeHeader(numOfPickup = 2, numOfDelivery = 4, postcode = "29832") {
        Column {
            Column {
                WaypointCard(
                    address = "1 Changi South street 2, Singapore 837484",
                    jobLabelsData = sample1,
                    name = "Butterfly shop",
                )
                WaypointCard(
                    address = "1 Changi South street 2, Singapore 837484",
                    jobLabelsData = sample1,
                    name = "Butterfly shop",
                )
            }
        }
    }
}

@Composable
fun PostcodeHeader(
    numOfDelivery: Int,
    numOfPickup: Int,
    postcode: String,
    waypointsContent: (@Composable() () -> Unit)
) {
    Column(modifier = Modifier.background(color = colors.gray9)) {
        Row(
            modifier = Modifier.padding(
                horizontal = spacings.spacingS,
            ).padding(bottom = spacings.spacingXs, top = spacings.spacingM)
        ) {
            Text(
                text = postcode,
                style = AkiraTheme.typography.heading6Bold,
                maxLines = 1,
                modifier = Modifier.weight(1f)
            )
            ItemWithCount(numOfItem = numOfDelivery, jobType = JobType.DELIVERY)
            ItemWithCount(numOfItem = numOfPickup, jobType = JobType.PICKUP)
        }
        waypointsContent()
    }
}