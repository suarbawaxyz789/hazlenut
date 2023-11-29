package com.example.hazelnut.ui.features.ninjas.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.items.entities.BonusCalculationMessageCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.CategoryHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.DangerCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.DeductionExpandableListItem
import com.example.hazelnut.ui.features.ninjas.items.entities.DriverInformationItem
import com.example.hazelnut.ui.features.ninjas.items.entities.InstructionHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.ListItem
import com.example.hazelnut.ui.features.ninjas.items.entities.MessageCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.MonthlyBonusItem
import com.example.hazelnut.ui.features.ninjas.items.entities.ParcelTypeCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.PointByParcelItem
import com.example.hazelnut.ui.features.ninjas.utils.StringUtil
import com.example.hazelnut.ui.theme.ninjas.Common
import com.example.hazelnut.ui.theme.ninjas.TextView
import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

@Composable
fun EarningListComponent(data: List<ListItem>) {
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

                EarningItemType.DEDUCTION_EXPANDABLE_LIST -> {
                    ExpandableItem(item as DeductionExpandableListItem)
                }

                EarningItemType.INSTRUCTION_DRIVER_INFORMATION -> {
                    DriverInformation(item as DriverInformationItem)
                }

                EarningItemType.MONTHLY_BONUS_CARD -> {
                    MonthlyBonusCard(item as MonthlyBonusItem)
                }

                EarningItemType.DANGER_CARD -> {
                    DangerCardComponent(item as DangerCardItem)
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
fun MonthlyBonusCard(monthlyBonusItem: MonthlyBonusItem) {
    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    ) {
        Common.Divider()
        Row(
            modifier = Modifier.padding(top = 14.dp, bottom = 10.dp),
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.weight(1f, true)
            ) {
                TextView.Regular(
                    text = monthlyBonusItem.title,
                    fontSize = 14.sp,
                    color = R.color.neutral_grey
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                TextView.Bold(
                    text = monthlyBonusItem.value, textAlign = TextAlign.End
                )
            }
        }
        Common.Divider()
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
                        R.string.suffix_points, StringUtil.formatPoint(pointByParcelItem.point)
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
fun DisplayImage(imageResId: Int, modifier: Modifier = Modifier) {
    val painter: Painter = painterResource(id = imageResId)

    Image(
        painter = painter,
        contentDescription = null, // Provide a description for accessibility
        modifier = modifier.wrapContentWidth(),
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
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
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
            .padding(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 30.dp)
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


@Composable
public fun DangerCardComponent(item: DangerCardItem) {
    Card(
        modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = colorResource(id = R.color.danger_card_background),
        elevation = 0.dp
    ) {
        TextView.Italic(
            modifier = Modifier.padding(15.dp),
            text = item.message,
            color = R.color.danger_card_text_color
        )
    }
}

@Composable
fun ExpandableItem(deductionItem: DeductionExpandableListItem) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
        Column {
            Common.Divider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
            ) {
                TextView.Bold(
                    text = deductionItem.title,
                    modifier = Modifier
                        .padding(top = 11.dp, bottom = 11.dp),
                )
                Spacer(modifier = Modifier.weight(1f))
                DisplayImage(
                    if (expanded) R.drawable.icon_m_angle_up else R.drawable.icon_m_angle_down,
                    modifier = Modifier.padding(end = 20.dp)
                )

            }
            Common.Divider()
        }

        if (expanded) {
            Column {
                TextView.Regular(
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                    text = deductionItem.description,
                    color = R.color.gray8f
                )
            }
        }
    }
}