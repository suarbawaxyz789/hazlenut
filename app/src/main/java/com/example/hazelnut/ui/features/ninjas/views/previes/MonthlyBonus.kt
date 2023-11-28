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
import com.example.hazelnut.ui.features.ninjas.items.entities.DangerCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.InstructionHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.MonthlyBonusItem
import com.example.hazelnut.ui.features.ninjas.views.BottomSheetHeader
import com.example.hazelnut.ui.features.ninjas.views.EarningListComponent

//@VisibleForTesting
@Preview
@Composable
internal fun MonthlyBonusPreview() {
    var itemList = listOf(
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
