package com.example.hazelnut.ui.features.ninjas.items.entities

import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

data class MessageCardItem(
    val text: String,
) : ListItem {
    override val earningType: EarningItemType
        get() = EarningItemType.MESSAGE_CARD_ITEM

}
