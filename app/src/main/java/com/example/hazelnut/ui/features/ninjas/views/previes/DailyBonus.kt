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
import com.example.hazelnut.ui.features.ninjas.items.entities.InstructionHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.MessageCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.PointByParcelItem
import com.example.hazelnut.ui.features.ninjas.views.BottomSheetHeader
import com.example.hazelnut.ui.features.ninjas.views.EarningListComponent

//@VisibleForTesting
@Preview
@Composable
internal fun DailyBonusTestPreview() {
    var itemList = listOf(
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
