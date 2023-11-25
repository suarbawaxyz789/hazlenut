package com.example.hazelnut.ui.features.ninjas.items.entities

import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

data class BonusCalculationMessageCardItem(
    val message: Int
) : ListItem {
    override val earningType: EarningItemType
        get() = EarningItemType.BONUS_CALCULATION_MESSAGE_CARD
}