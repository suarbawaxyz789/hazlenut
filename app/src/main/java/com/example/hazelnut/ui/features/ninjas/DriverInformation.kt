package com.example.hazelnut.ui.features.ninjas

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.hazelnut.ui.features.ninjas.items.entities.ListItem
import com.example.hazelnut.ui.features.ninjas.items.entities.ParcelTypeCardItem
import com.example.hazelnut.ui.features.ninjas.utils.StringUtil
import com.example.hazelnut.ui.theme.ninjas.Common
import com.example.hazelnut.ui.theme.ninjas.TextView
import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType
import androidx.compose.foundation.lazy.items
import com.example.hazelnut.ui.features.ninjas.items.entities.CategoryHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.DriverInformationItem

//@VisibleForTesting
@Preview
@Composable
internal fun EarningPerParcelTestPreview() {

    var itemList = listOf(
        DriverInformationItem(
            driverName = "Driver Name", region = "Greater Jakarta A",
            instructionTitle = "Earning per parcel",
            instruction = "The amount you'll receive for delivering a parcel depends on the size of the parcel.\\n\" + \"1. Marketplace: Lazada, Tiktok, Shopee, Tokopedia, Bukalapak, Blibli\\n\" + \"2. Non-MP: Soscom, KPP, BPJS, Bank, Mitra",
        ), CategoryHeaderItem(
            title = "DELIVERY",
        ), ParcelTypeCardItem(
            parcelCategory = "Regular | non-MP",
            parcelSize = "Small & Medium",
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 6000.toDouble()
        ), ParcelTypeCardItem(
            parcelCategory = "Regular | marketplace",
            parcelSize = "Small & Medium",
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 4800.toDouble()
        ), CategoryHeaderItem(
            title = "PICKUP",
        ), ParcelTypeCardItem(
            parcelCategory = "Regular | pickup",
            parcelSize = "Small & Medium",
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 6000.toDouble()
        ), ParcelTypeCardItem(
            parcelCategory = "Bulky | pickup",
            parcelSize = "Small & Medium",
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 8200.toDouble()
        )
    )

    /// content goes here.
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

//@VisibleForTesting
@Preview
@Composable
internal fun EarningPerDeliveryTestPreview() {

    var itemList = listOf(
        DriverInformationItem(
            driverName = "Driver Name", region = "Greater Jakarta A",
            instructionTitle = "Earning Per Delivery",
            instruction = "the amount you’ll receive for delivering a parcel depends on the size of the parcel, who is sending the parcel and in what region you’re delivering it.",
        ),
        ParcelTypeCardItem(
            parcelCategory = "Regular | non-MP",
            parcelSize = "Small & Medium",
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 6000.toDouble()
        ),
        ParcelTypeCardItem(
            parcelCategory = "Regular | marketplace",
            parcelSize = "Small & Medium",
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 4800.toDouble()
        ),
        ParcelTypeCardItem(
            parcelCategory = "RTS",
            parcelSize = "Large & X-Large",
            parcelPrice = 0.toDouble(),
            totalParcelDelivered = 0,
            totalParcelIncome = 1000.toDouble()
        ),
    )

    /// content goes here.
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

                EarningItemType.MONTH_TOTAL_EARNING -> {

                }

                EarningItemType.INSTRUCTION_DRIVER_INFORMATION -> {
                    DriverInformation(item as DriverInformationItem)
                }

                EarningItemType.CATEGORY_HEADER -> {
                    CategoryHeaderItem(item as CategoryHeaderItem)
                }

                EarningItemType.DAILY_BONUS_TOTAL_CARD -> {

                }

                EarningItemType.DAILY_BONUS_CARD -> {

                }

                EarningItemType.GOAL_CARD -> {


                }

                EarningItemType.BONUS_CALCULATION_MESSAGE_CARD -> {

                }

                EarningItemType.LEARN_SALARY_CALCULATION_CARD -> {

                }

                EarningItemType.BAR_GRAPH_CARD -> {

                }

                EarningItemType.DAILY_EARNING_CARD -> {

                }

                else -> {

                }
            }

        }
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
            text = categoryHeaderItem.title,
            fontSize = 14.sp,
            color = R.color.gray8f
        )
        Common.Divider(modifier = Modifier.padding(top = 10.dp))
    }
}

@Composable
fun DriverInformation(
    driverInformationCardItem: DriverInformationItem,
) {
    Column {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 30.dp)
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
                    text = driverInformationCardItem.region,
                    textAlign = TextAlign.End,
                    fontSize = 16.sp
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextView.Bold(
                    text = driverInformationCardItem.instructionTitle,
                    textAlign = TextAlign.End,
                    fontSize = 18.sp,
                )
                TextView.Regular(
                    text = driverInformationCardItem.instruction,
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    color = R.color.gray8f,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
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