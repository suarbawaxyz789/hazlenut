package ninjavan.swiftninja.mvvm.ui.myearning.items.viewtype

enum class EarningItemType {
    MONTH_TOTAL_EARNING,
    PARCEL_TYPE_CARD,
    DAILY_BONUS_TOTAL_CARD,
    DAILY_BONUS_CARD,
    GOAL_CARD,
    BONUS_CALCULATION_MESSAGE_CARD,
    LEARN_SALARY_CALCULATION_CARD,
    BAR_GRAPH_CARD,
    DAILY_EARNING_CARD,
    INSTRUCTION_DRIVER_INFORMATION,
    INSTRUCTION_HEADER,
    POINT_BY_PARCEL_TYPE_CARD,
    MESSAGE_CARD_ITEM,
    CATEGORY_HEADER;

    companion object {
        private val values = values()
        internal fun fromOrdinal(ordinal: Int) = values[ordinal]
    }
}