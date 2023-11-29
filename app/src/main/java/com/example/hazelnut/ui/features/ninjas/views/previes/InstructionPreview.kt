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
import com.example.hazelnut.ui.features.ninjas.items.entities.BonusCalculationMessageCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.CategoryHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.DangerCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.DeductionExpandableListItem
import com.example.hazelnut.ui.features.ninjas.items.entities.DriverInformationItem
import com.example.hazelnut.ui.features.ninjas.items.entities.InstructionHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.MessageCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.MonthlyBonusItem
import com.example.hazelnut.ui.features.ninjas.items.entities.ParcelTypeCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.PointByParcelItem
import com.example.hazelnut.ui.features.ninjas.views.BottomSheetHeader
import com.example.hazelnut.ui.features.ninjas.views.EarningListComponent

//@VisibleForTesting
@Preview
@Composable
internal fun InstructionPreview() {
    var itemList = listOf(
        DriverInformationItem(
            driverName = "Driver Name",
            region = LocalContext.current.getString(R.string.region_greater_jakarta),
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
        InstructionHeaderItem(
            title = LocalContext.current.getString(R.string.daily_bonus),
            instruction = LocalContext.current.getString(R.string.daily_bonus_delivery_instruction),
        ),
        /// TODO put widget from Risvan
        MessageCardItem(
            text = LocalContext.current.getString(R.string.theAmoutOfPointsYouWillEarnDependsOnTheSize)
        ),
        CategoryHeaderItem(
            title = LocalContext.current.getString(R.string.header_delivery),
        ),
        PointByParcelItem(
            parcelType = LocalContext.current.getString(R.string.regular_marketplace),
            point = 1.0,
        ),
        PointByParcelItem(
            parcelType = LocalContext.current.getString(R.string.regular_non_mp),
            point = 1.2,
        ),
        PointByParcelItem(
            parcelType = LocalContext.current.getString(R.string.bulky_marketplace),
            point = 2.5,
        ),
        PointByParcelItem(
            parcelType = LocalContext.current.getString(R.string.bulky_non_mp),
            point = 3.0,
        ),
        PointByParcelItem(
            parcelType = LocalContext.current.getString(R.string.parcel_rts),
            point = 0.5,
        ),
        BonusCalculationMessageCardItem(
            message = R.string.youCanSeeYourDailyBonusTarges
        ),
        InstructionHeaderItem(
            title = LocalContext.current.getString(R.string.montly_bonus),
            instruction = LocalContext.current.getString(R.string.montly_bonus_description),
        ),
        MonthlyBonusItem(
            title = LocalContext.current.getString(R.string.montly_deliveries),
            value = "800",
        ),
        MonthlyBonusItem(
            title = LocalContext.current.getString(R.string.success_rate),
            value = "90%",
        ),
        MonthlyBonusItem(
            title = LocalContext.current.getString(R.string.customer_complaints),
            value = LocalContext.current.getString(R.string.none),
        ),
        MonthlyBonusItem(
            title = LocalContext.current.getString(R.string.fraudenlent_behaviour),
            value = LocalContext.current.getString(R.string.none),
        ),
        DangerCardItem(
            message = LocalContext.current.getString(R.string.montly_danger_message_not_be_eligible_for_a_bonus),
        ),
        InstructionHeaderItem(
            title = LocalContext.current.getString(R.string.deduction),
            instruction = LocalContext.current.getString(R.string.deduction_description),
        ),
        DeductionExpandableListItem(
            LocalContext.current.getString(R.string.invalid_poda),
            LocalContext.current.getString(R.string.invalid_poda_description)
        ),
        DeductionExpandableListItem(
            LocalContext.current.getString(R.string.lost_and_damage),
            LocalContext.current.getString(R.string.lost_and_damage_description)
        ),
        DeductionExpandableListItem(
            LocalContext.current.getString(R.string.others),
            LocalContext.current.getString(R.string.others_description)
        )
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
