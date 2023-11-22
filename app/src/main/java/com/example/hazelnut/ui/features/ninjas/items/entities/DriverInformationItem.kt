package com.example.hazelnut.ui.features.ninjas.items.entities

import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

data class DriverInformationItem(
    val driverName: String,
    val region: String,
) : ListItem {
    override val earningType: EarningItemType
        get() = EarningItemType.INSTRUCTION_DRIVER_INFORMATION

}
