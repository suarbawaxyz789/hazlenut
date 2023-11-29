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
import com.example.hazelnut.ui.features.ninjas.items.entities.InstructionHeaderItem
import com.example.hazelnut.ui.features.ninjas.items.entities.MessageCardItem
import com.example.hazelnut.ui.features.ninjas.items.entities.MonthlyBonusItem
import com.example.hazelnut.ui.features.ninjas.items.entities.PointByParcelItem
import com.example.hazelnut.ui.features.ninjas.views.BottomSheetHeader
import com.example.hazelnut.ui.features.ninjas.views.EarningListComponent
import com.example.hazelnut.ui.features.ninjas.views.ExpandableItem

//@VisibleForTesting
@Preview
@Composable
internal fun DeductionPreview() {
    var itemList = listOf(
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
