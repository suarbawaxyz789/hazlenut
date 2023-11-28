package com.example.hazelnut.ui.features.ninjas.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.items.entities.BonusCalculationMessageCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.CategoryHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.DriverInformationItem
import com.example.hazelnut.ui.features.ninjas.items.entities.InstructionHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.ListItem
import com.example.hazelnut.ui.features.ninjas.items.entities.MessageCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.ParcelTypeCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.PointByParcelItem
import com.example.hazelnut.ui.features.ninjas.utils.StringUtil
import com.example.hazelnut.ui.theme.ninjas.Common
import com.example.hazelnut.ui.theme.ninjas.TextView
import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

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


@Composable
fun PointByParcelCard(pointByParcelItem: PointByParcelItem) {
    Column(
        modifier = Modifier.padding(top = 14.dp, start = 20.dp, end = 20.dp)
    ) {
        Row(
            modifier = Modifier, verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.weight(1f, true)
            ) {
                TextView.Regular(
                    text = pointByParcelItem.parcelType,
                    fontSize = 14.sp,
                    color = R.color.neutral_grey
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                TextView.Bold(
                    text = LocalContext.current.getString(
                        R.string.suffix_points, pointByParcelItem.point.toString()
                    ), textAlign = TextAlign.End
                )
            }
        }
        Common.Divider(
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
private fun EarningListComponent(data: List<ListItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp, bottom = 33.dp)
    ) {
        items(data) { item ->
            when (item.earningType) {
                EarningItemType.PARCEL_TYPE_CARD -> {
                    InstructionParcelsComponent(item as ParcelTypeCardItem)
                }

                EarningItemType.INSTRUCTION_HEADER -> {
                    InstructionHeader(item as InstructionHeaderItem)
                }

                EarningItemType.INSTRUCTION_DRIVER_INFORMATION -> {
                    DriverInformation(item as DriverInformationItem)
                }

                EarningItemType.CATEGORY_HEADER -> {
                    CategoryHeaderItem(item as CategoryHeaderItem)
                }

                EarningItemType.POINT_BY_PARCEL_TYPE_CARD -> {
                    PointByParcelCard(item as PointByParcelItem)
                }

                EarningItemType.MESSAGE_CARD_ITEM -> {
                    MessageCardItem(item as MessageCardItem)
                }

                EarningItemType.BONUS_CALCULATION_MESSAGE_CARD -> {
                    BonusCardComponent(
                        item = item as BonusCalculationMessageCardItem,
                        context = LocalContext.current
                    )
                }

                else -> {

                }
            }

        }
    }
}

@Composable
private fun MessageCardItem(
    messageCardItem: MessageCardItem,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextView.Regular(
            text = messageCardItem.text, fontSize = 14.sp, color = R.color.gray8f
        )
    }

}

@Composable
fun DisplayImage(imageResId: Int) {
    val painter: Painter = painterResource(id = imageResId)

    Image(
        painter = painter,
        contentDescription = null, // Provide a description for accessibility
        modifier = Modifier.wrapContentWidth(),
        contentScale = ContentScale.Fit // Adjust this based on how you want the image to fit
    )
}

@Composable
fun BottomSheetHeader(
    title: String? = null,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DisplayImage(
            R.drawable.icon_m_times
        )
        title?.let {
            TextView.Bold(
                text = title,
                textAlign = TextAlign.End,
                fontSize = 18.sp,
            )
        }
    }
}


@Composable
private fun CategoryHeaderItem(
    categoryHeaderItem: CategoryHeaderItem,
) {
    Column(
        modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp)
    ) {
        TextView.Bold(
            text = categoryHeaderItem.title, fontSize = 14.sp, color = R.color.gray8f
        )
        Common.Divider(modifier = Modifier.padding(top = 10.dp))
    }
}

@Composable
fun DriverInformation(
    driverInformationCardItem: DriverInformationItem,
) {
    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 10.dp)
            .wrapContentWidth()
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        DisplayImage(
            R.drawable.driver_information,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 12.dp)
        ) {
            TextView.Bold(
                text = driverInformationCardItem.driverName,
                textAlign = TextAlign.End,
                fontSize = 18.sp,
            )
            TextView.Regular(
                text = driverInformationCardItem.region, textAlign = TextAlign.End, fontSize = 16.sp
            )
        }
    }
}

@Composable
fun InstructionHeader(
    instructionHeaderItem: InstructionHeaderItem,
) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 30.dp)
            .fillMaxWidth(),
    ) {
        TextView.Bold(
            text = instructionHeaderItem.title,
            textAlign = TextAlign.End,
            fontSize = 18.sp,
        )
        TextView.Regular(
            text = instructionHeaderItem.instruction,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            color = R.color.gray8f,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
private fun InstructionParcelsComponent(
    parcelTypeCardItem: ParcelTypeCardItem,
) {
    Column(
        modifier = Modifier.padding(top = 14.dp, start = 20.dp, end = 20.dp)
    ) {
        Row(
            modifier = Modifier, verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.weight(1f, true)
            ) {
                TextView.Bold(text = parcelTypeCardItem.parcelCategory, fontSize = 14.sp)
                TextView.Regular(
                    modifier = Modifier.padding(top = 2.dp),
                    text = parcelTypeCardItem.parcelSize,
                    color = R.color.color_b3b3b3
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                TextView.Bold(
                    text = LocalContext.current.getString(
                        R.string.prefix_rp_with_amount,
                        StringUtil.getFormattedAmountInDouble(parcelTypeCardItem.totalParcelIncome)
                    ), textAlign = TextAlign.End
                )
            }
        }
        Common.Divider(
            modifier = Modifier.padding(top = 10.dp)
        )
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
//@Preview
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

@Composable
fun PointCircleLarge(
    modifier: Modifier = Modifier,
    point: Int,
) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .size(47.dp)
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
                    R.string.prefix_rp_with_amount, StringUtil.getFormattedAmountInDouble(300000.0)
                ),
                textAlign = TextAlign.End,
                fontSize = 14.sp,
                color = R.color.neutral_grey,
            )
        }
    }
}

/// TODO find the way to put 120 point based on percent of total points
@Composable
fun PointLinearProgressIndicator(
    progress: Float, backgroundColor: Color, indicatorColor: Color
) {
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
        LinearProgressIndicator(
            progress = progress,
            backgroundColor = backgroundColor,
            color = indicatorColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, end = 20.dp)
        )
        Row(
            modifier = Modifier
                .offset(y = -25.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f)
            ) {
                PointCircleSmall(point = 120, modifier = Modifier.offset(x = 100.dp))
            }
            PointCircleLarge(point = 300)
        }
        TextView.Regular(
            text = "64.6 Points",
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            color = R.color.neutral_grey,
            modifier = Modifier.offset(y = -63.dp),
        )
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