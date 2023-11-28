package com.example.hazelnut.ui.features.ninjas.items.entities

import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

data class DangerCardItem(
    val message: String
) : ListItem {
    override val earningType: EarningItemType
        get() = EarningItemType.DANGER_CARD
}