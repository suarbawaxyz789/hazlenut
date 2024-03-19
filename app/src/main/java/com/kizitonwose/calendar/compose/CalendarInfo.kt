package com.kizitonwose.calendar.compose

import com.kizitonwose.calendar.core.OutDateStyle
import org.threeten.bp.DayOfWeek

internal data class CalendarInfo(
    val indexCount: Int,
    private val firstDayOfWeek: DayOfWeek? = null,
    private val outDateStyle: OutDateStyle? = null,
)
