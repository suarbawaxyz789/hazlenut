package ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype

enum class ParcelCategory(val value: String, val category: String, val size: String) {
    REGULAR_NON_MARKETPLACE_DELIVERY(
        "regular_non_marketplace_delivery",
        "Regular | non-Marketplace",
        "Small & Medium"
    ),
    REGULAR_MARKETPLACE_DELIVERY(
        "regular_marketplace_delivery",
        "Regular | Marketplace",
        "Small & Medium"
    ),
    BULKY_NON_MARKETPLACE_DELIVERY(
        "bulky_non_marketplace_delivery",
        "Bulky | non-Marketplace",
        "Large & X-Large"
    ),
    BULKY_MARKETPLACE_DELIVERY(
        "bulky_marketplace_delivery",
        "Bulky | Marketplace",
        "Large & X-Large"
    ),
    RTS_DELIVERY("RTS_delivery", "RTS", ""),
    REGULAR_PICKUP("regular_pickup", "Regular | Pickup", "Small & Medium"),
    BULKY_PICKUP("bulky_pickup", "Bulky | Pickup", "Large & X-Large");

    companion object {
        fun fromValue(value: String): ParcelCategory {
            return values().first { it.value == value }
        }
    }
}