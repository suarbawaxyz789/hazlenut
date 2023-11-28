package com.example.hazelnut.ui.features.ninjas.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.items.entities.DriverInformationItem
import com.example.hazelnut.ui.features.ninjas.items.entities.InstructionHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.ParcelTypeCardItem
import com.example.hazelnut.ui.features.ninjas.utils.StringUtil
import com.example.hazelnut.ui.theme.ninjas.TextView


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
//        InstructionHeaderItem(
//            title = LocalContext.current.getString(R.string.daily_bonus),
//            instruction = LocalContext.current.getString(R.string.daily_bonus_delivery_instruction),
//        ),
//        MessageCardItem(
//            text = LocalContext.current.getString(R.string.theAmoutOfPointsYouWillEarnDependsOnTheSize)
//        ),
//        CategoryHeaderItem(
//            title = LocalContext.current.getString(R.string.header_delivery),
//        ),
//        PointByParcelItem(
//            parcelType = LocalContext.current.getString(R.string.regular_non_mp),
//            point = 1.4,
//        ),
//        CategoryHeaderItem(
//            title = "PICKUP",
//        ),
//        PointByParcelItem(
//            parcelType = LocalContext.current.getString(R.string.regular_non_mp),
//            point = 1.4,
//        ),
//        PointByParcelItem(
//            parcelType = "Bulky | pickup",
//            point = 0.75,
//        ),
//        BonusCalculationMessageCardItem(
//            message = R.string.youCanSeeYourDailyBonusTarges
//        ),
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


//
////@VisibleForTesting
////@Preview
//@Composable
//internal fun EarningPerParcelTestPreview() {
//
//    var itemList = listOf(
//        DriverInformationItem(
//            driverName = "Driver Name", region = LocalContext.current.getString(R.string.region_greater_jakarta
//            ),
//        ), InstructionHeaderItem(
//            title = LocalContext.current.getString(R.string.earning_per_parcel_title),
//            instruction = LocalContext.current.getString(R.string.parcel_instruction),
//        ), CategoryHeaderItem(
//            title = LocalContext.current.getString(R.string.header_delivery),
//        ), ParcelTypeCardItem(
//            parcelCategory = LocalContext.current.getString(R.string.regular_non_mp),
//            parcelSize = LocalContext.current.getString(R.string.small_medium),
//            parcelPrice = 0.toDouble(),
//            totalParcelDelivered = 0,
//            totalParcelIncome = 6000.toDouble()
//        ), ParcelTypeCardItem(
//            parcelCategory = LocalContext.current.getString(R.string.regular_marketplace),
//            parcelSize = LocalContext.current.getString(R.string.small_medium),
//            parcelPrice = 0.toDouble(),
//            totalParcelDelivered = 0,
//            totalParcelIncome = 4800.toDouble()
//        ), CategoryHeaderItem(
//            title = "PICKUP",
//        ), ParcelTypeCardItem(
//            parcelCategory = "Regular | pickup",
//            parcelSize = LocalContext.current.getString(R.string.small_medium),
//            parcelPrice = 0.toDouble(),
//            totalParcelDelivered = 0,
//            totalParcelIncome = 6000.toDouble()
//        ), ParcelTypeCardItem(
//            parcelCategory = "Bulky | pickup",
//            parcelSize = LocalContext.current.getString(R.string.small_medium),
//            parcelPrice = 0.toDouble(),
//            totalParcelDelivered = 0,
//            totalParcelIncome = 8200.toDouble()
//        )
//    )
//    Row(
//        modifier = Modifier
//            .background(color = colorResource(id = R.color.white))
//            .fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            BottomSheetHeader()
//            EarningListComponent(itemList)
//        }
//    }
//}

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

@Composable
fun PointCircleSmall(
    modifier: Modifier = Modifier,
    point: Int,
) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(37.dp)
                    .border(
                        width = 2.dp, color = colorResource(id = R.color.white), shape = CircleShape
                    ),
            ) {
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .background(colorResource(id = R.color.indicator_thumb_yellow), CircleShape)
                        .padding(2.dp), contentAlignment = Alignment.Center
                ) {
                    TextView.Regular(
                        text = point.toString(),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        color = R.color.white
                    )
                }
            }
            TextView.Bold(
                text = LocalContext.current.getString(
                    R.string.prefix_rp_with_amount, StringUtil.getFormattedAmountInDouble(150000.0)
                ),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = R.color.neutral_grey,
            )
        }
    }
}


//@Preview
@Composable
fun PreviewCustomLinearProgress() {
    Column {
        PointLinearProgressIndicator(
            progress = 0.2f, backgroundColor = Color.Gray, indicatorColor = Color.Red
        )
    }
}