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
import com.example.hazelnut.ui.features.ninjas.items.entities.CategoryHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.DriverInformationItem
import com.example.hazelnut.ui.features.ninjas.items.entities.InstructionHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.ParcelTypeCardItem
import com.example.hazelnut.ui.features.ninjas.views.BottomSheetHeader
import com.example.hazelnut.ui.features.ninjas.views.EarningListComponent


//@VisibleForTesting
@Preview
@Composable
internal fun EarningPerParcelTestPreview() {
    var itemList = listOf(
        DriverInformationItem(
            driverName = "Driver Name", region = LocalContext.current.getString(R.string.region_greater_jakarta),
        ),
        InstructionHeaderItem(
            title = LocalContext.current.getString(R.string.earning_per_delivery_title),
            instruction = LocalContext.current.getString(R.string.delivery_instruction),
        ),
        CategoryHeaderItem(
            title = LocalContext.current.getString(R.string.header_delivery),
        ),
        ParcelTypeCardItem(
            parcelCategory = LocalContext.current.getString(R.string.regular_non_mp),
            parcelSize = LocalContext.current.getString(R.string.small_medium),
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 2520.toDouble()
        ),
        ParcelTypeCardItem(
            parcelCategory = LocalContext.current.getString(R.string.regular_marketplace),
            parcelSize = LocalContext.current.getString(R.string.small_medium),
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 2100.toDouble()
        ),
        ParcelTypeCardItem(
            parcelCategory = LocalContext.current.getString(R.string.bulky_marketplace),
            parcelSize = LocalContext.current.getString(R.string.large_x_large),
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 5250.toDouble()
        ),
        ParcelTypeCardItem(
            parcelCategory = LocalContext.current.getString(R.string.bulky_non_mp),
            parcelSize = LocalContext.current.getString(R.string.large_x_large),
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 6300.toDouble()
        ),
        ParcelTypeCardItem(
            parcelCategory = LocalContext.current.getString(R.string.parcel_rts),
            parcelSize = LocalContext.current.getString(R.string.large_x_large),
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 1050.toDouble()
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