package com.example.hazelnut.ui.features.ninjas.items.entities

import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

data class DeductionExpandableListItem(
    val title: String,
    val description : String
) : ListItem {
    override val earningType: EarningItemType
        get() = EarningItemType.DEDUCTION_EXPANDABLE_LIST

}
