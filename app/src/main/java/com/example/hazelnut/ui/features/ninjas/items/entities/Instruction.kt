package com.example.hazelnut.ui.features.ninjas.items.entities

import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

data class Instruction(
    val driverName: String,
    val region: String,
    val instructionTitle : String,
    val instruction : String,
) : ListItem {
    override val earningType: EarningItemType
        get() = EarningItemType.INSTRUCTION_DRIVER_INFORMATION

}
