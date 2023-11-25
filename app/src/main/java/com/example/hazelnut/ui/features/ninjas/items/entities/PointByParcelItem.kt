package com.example.hazelnut.ui.features.ninjas.items.entities

import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

data class PointByParcelItem(
    val parcelType: String,
    val point: Double,
) : ListItem {
    override val earningType: EarningItemType
        get() = EarningItemType.POINT_BY_PARCEL_TYPE_CARD

}
