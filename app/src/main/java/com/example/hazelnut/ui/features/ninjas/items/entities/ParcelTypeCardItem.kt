package com.example.hazelnut.ui.features.ninjas.items.entities

import ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype.EarningItemType

data class ParcelTypeCardItem(
    val totalParcelDelivered: Int,
    val parcelCategory: String,
    val parcelSize: String,
    val totalParcelIncome: Double,
    val parcelPrice: Double
) : ListItem {
    override val earningType: EarningItemType
        get() = EarningItemType.PARCEL_TYPE_CARD

}
