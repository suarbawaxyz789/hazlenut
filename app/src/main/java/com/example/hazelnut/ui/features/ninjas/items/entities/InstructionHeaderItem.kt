package com.example.hazelnut.ui.features.ninjas.items.entities

import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

data class InstructionHeaderItem(
    val title : String,
    val instruction : String,
) : ListItem {
    override val earningType: EarningItemType
        get() = EarningItemType.INSTRUCTION_HEADER

}
