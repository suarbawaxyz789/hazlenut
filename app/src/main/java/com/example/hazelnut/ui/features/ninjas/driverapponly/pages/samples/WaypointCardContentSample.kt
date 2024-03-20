package com.example.hazelnut.ui.features.ninjas.driverapponly.pages.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.ui.features.ninjas.driverapponly.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.PostcodeCard
import com.example.hazelnut.ui.features.ninjas.driverapponly.WaypointCard

@Composable
fun WaypointCardContentSample() {

    /// 1 job 1 parcel
    var sample1: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111"))
    )

    /// 1 job 2 parcel
    var sample2: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
    )

    /// 2 job 2 parcel
    var sample3: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")),
        Pair(JobType.PICKUP, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AkiraTheme.colors.gray9),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        PostcodeCard(numOfDelivery = 1, numOfPickup = 3, postcode = "19832") {
            Column {
                WaypointCard(
                    address = "1 Changi South street 2, Singapore 837484",
                    jobLabelsData = sample1,
                    name = "Butterfly shop",
                )

                WaypointCard(
                    address = "2 Changi South street 2, Singapore 837484",
                    jobLabelsData = sample2,
                    name = "Butterfly shop",
                    enable = false,
                )

                WaypointCard(
                    address = "3 Changi South street 2, Singapore 837484",
                    jobLabelsData = sample3,
                    name = "Butterfly shop",
                )

                WaypointCard(
                    address = "3 Changi South street 2, Singapore 837484",
                    jobLabelsData = sample1,
                    name = "Butterfly shop",
                )

                WaypointCard(
                    address = "3 Changi South street 2, Singapore 837484",
                    jobLabelsData = sample2,
                    name = "Butterfly shop",
                    enable = false,
                )

                WaypointCard(
                    address = "3 Changi South street 2, Singapore 837484",
                    jobLabelsData = sample3,
                    name = "Butterfly shop",
                )
            }
        }

        PostcodeCard(numOfDelivery = 1, numOfPickup = 3, postcode = "2903789") {
            WaypointCard(
                address = "3 Changi South street 2, Singapore 837484",
                jobLabelsData = sample1,
                name = "Butterfly shop",
            )

            WaypointCard(
                address = "3 Changi South street 2, Singapore 837484",
                jobLabelsData = sample2,
                name = "Butterfly shop",
                enable = false,
            )

            WaypointCard(
                address = "3 Changi South street 2, Singapore 837484",
                jobLabelsData = sample3,
                name = "Butterfly shop",
            )

            WaypointCard(
                address = "3 Changi South street 2, Singapore 837484",
                jobLabelsData = sample1,
                name = "Butterfly shop",
            )

            WaypointCard(
                address = "3 Changi South street 2, Singapore 837484",
                jobLabelsData = sample2,
                name = "Butterfly shop",
                enable = false,
            )

            WaypointCard(
                address = "3 Changi South street 2, Singapore 837484",
                jobLabelsData = sample3,
                name = "Butterfly shop",
            )

        }

    }

}
