package com.example.hazelnut.ui.features.ninjas.driverapponly.pages.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.ui.features.ninjas.driverapponly.PostCard

@Composable
fun PostCodeContentSample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AkiraTheme.colors.gray9),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        PostCard(
            address = "3 Changi South street 2, Singapore 837484",
            numOfDeliveryParcel = 11,
            numOfWaypoints = 2, numOfPickupParcel = 10,
        )
        PostCard(
            address = "3 Changi South street 2, Singapore 837484",
            numOfDeliveryParcel = 11,
            numOfWaypoints = 2, numOfPickupParcel = 10,
            enable = false,
        )
        PostCard(
            address = "3 Changi South street 2, Singapore 837484",
            numOfDeliveryParcel = 11,
            numOfWaypoints = 2, numOfPickupParcel = 10,
        )
        PostCard(
            address = "3 Changi South street 2, Singapore 837484",
            numOfDeliveryParcel = 11,
            numOfWaypoints = 2, numOfPickupParcel = 10,
        )
        PostCard(
            address = "3 Changi South street 2, Singapore 837484",
            numOfDeliveryParcel = 11,
            numOfWaypoints = 2, numOfPickupParcel = 10,
        )
    }

}
