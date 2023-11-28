package com.example.hazelnut.ui.features.ninjas.views.previes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.items.entities.DriverInformationItem
import com.example.hazelnut.ui.features.ninjas.items.entities.InstructionHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.ParcelTypeCardItem
import com.example.hazelnut.ui.features.ninjas.views.BottomSheetHeader
import com.example.hazelnut.ui.features.ninjas.views.EarningListComponent

//@VisibleForTesting
@Preview
@Composable
internal fun EarningPerDeliveryTestPreview() {

    var itemList = listOf(
        DriverInformationItem(
            driverName = "Driver Name", region = "Greater Jakarta A",
        ),
        InstructionHeaderItem(
            title = "Earning Per Delivery",
            instruction = "the amount you’ll receive for delivering a parcel depends on the size of the parcel, who is sending the parcel and in what region you’re delivering it.",
        ),
        ParcelTypeCardItem(
            parcelCategory = LocalContext.current.getString(R.string.regular_non_mp),
            parcelSize = LocalContext.current.getString(R.string.small_medium),
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 6000.toDouble()
        ),
        ParcelTypeCardItem(
            parcelCategory = LocalContext.current.getString(R.string.regular_marketplace),
            parcelSize = LocalContext.current.getString(R.string.small_medium),
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 4800.toDouble()
        ),
        ParcelTypeCardItem(
            parcelCategory = "RTS",
            parcelSize = LocalContext.current.getString(R.string.large_x_large),
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 1000.toDouble()
        ),
    )
    Row(
        modifier = Modifier
            .background(color = colorResource(id = R.color.white))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            BottomSheetHeader()
            EarningListComponent(itemList)
        }
    }
}
