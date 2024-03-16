package com.example.hazelnut.ui.features.ninjas.akira.calendarpicker

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.R
import com.kizitonwose.calendar.compose.CalendarState
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.CalendarMonth
import com.kizitonwose.calendar.core.DayPosition
import com.kizitonwose.calendar.core.daysOfWeek
import com.kizitonwose.calendar.core.nextMonth
import com.kizitonwose.calendar.core.previousMonth
import com.kizitonwose.calendar.sample.compose.rememberFirstVisibleMonthAfterScroll
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

/**
 * Documentation is on.
 * https://github.com/kizitonwose/Calendar
 */

@RequiresApi(Build.VERSION_CODES.O)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun testPreview() {
    val daysOfWeek = daysOfWeek()

    var selectedDateState = remember {
        mutableStateOf(LocalDate.now())
    }
    val currentMonth = remember { YearMonth.now() }
    val startMonth = remember { currentMonth.minusMonths(100) }
    val endMonth = remember { currentMonth.plusMonths(100) }

    val monthState = rememberCalendarState(
        startMonth = startMonth,
        endMonth = endMonth,
        firstVisibleMonth = currentMonth,
        firstDayOfWeek = daysOfWeek.first(),
    )

    CalendarPicker(state = monthState, selectedDate = selectedDateState, onClick = {
        /// TODO
    })
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarPicker(
    state: CalendarState = rememberCalendarState(),
    selectedDate: MutableState<LocalDate>,
    onClick: (CalendarDay) -> Unit
) {
    Column {
        CalendarTitle(monthState = state)
        HorizontalCalendar(
            state = state,
            userScrollEnabled = false,
            dayContent = {
                DayComponent(it, selectedDate, onClick = onClick)
            },
            monthHeader = { month ->
                MonthHeader(month)
            },
            monthBody = { _, content ->
                Box(
                    modifier = Modifier.background(color = colors.white)
                ) {
                    content() // Render the provided content!
                }
            },
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun CalendarTitle(
    monthState: CalendarState,
) {
    val visibleMonth = rememberFirstVisibleMonthAfterScroll(monthState)
    Box(modifier = Modifier.background(color = colors.white)) {
        MonthAndWeekCalendarTitle(
            currentMonth = visibleMonth.yearMonth,
            monthState = monthState,
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MonthAndWeekCalendarTitle(
    currentMonth: YearMonth,
    monthState: CalendarState,
) {
    val coroutineScope = rememberCoroutineScope()
    SimpleCalendarTitle(
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 8.dp),
        currentMonth = currentMonth,
        goToPrevious = {
            coroutineScope.launch {
                val targetMonth = monthState.firstVisibleMonth.yearMonth.previousMonth
                monthState.animateScrollToMonth(targetMonth)
            }
        },
        goToNext = {
            coroutineScope.launch {
                val targetMonth = monthState.firstVisibleMonth.yearMonth.nextMonth
                monthState.animateScrollToMonth(targetMonth)
            }
        },
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SimpleCalendarTitle(
    modifier: Modifier,
    currentMonth: YearMonth,
    goToPrevious: () -> Unit,
    goToNext: () -> Unit,
) {
    // Define a custom DateTimeFormatter to format the YearMonth
    val formatter = DateTimeFormatter.ofPattern("MMM yyyy")

    Column {
        Row(
            modifier = modifier.height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CalendarNavigationIcon(
                icon = painterResource(id = R.drawable.expanable_arrow_up),
                contentDescription = "Previous",
                onClick = goToPrevious,
                modifier = Modifier.rotate(270F)
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .testTag("MonthTitle"),
                text = currentMonth.format(formatter),
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
            )
            CalendarNavigationIcon(
                icon = painterResource(id = R.drawable.expanable_arrow_up),
                contentDescription = "Next",
                onClick = goToNext,
                modifier = Modifier.rotate(90F)
            )
        }
        Divider()
    }
}


@Composable
private fun CalendarNavigationIcon(
    icon: Painter,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) = Box(
    modifier = Modifier
        .wrapContentSize()
        .aspectRatio(1f)
        .clip(shape = CircleShape)
        .clickable(role = Role.Button, onClick = onClick),
) {
    Icon(
        modifier = modifier
            .size(spacings.spacingXs)
            .align(Alignment.Center),
        painter = icon,
        contentDescription = contentDescription,
    )
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DaysOfWeekTitle(daysOfWeek: List<DayOfWeek>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (dayOfWeek in daysOfWeek) {
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun MonthHeader(month: CalendarMonth) {
    val daysOfWeek = month.weekDays.first().map { it.date.dayOfWeek }
    Column(modifier = Modifier.background(color = colors.white)) {
        Spacer(Modifier.padding(bottom = 10.dp))
        DaysOfWeekTitle(daysOfWeek = daysOfWeek)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DayComponent(
    day: CalendarDay,
    selectedDate: MutableState<LocalDate>,
    onClick: (CalendarDay) -> Unit
) {

    var isCurrentOrFuture = !day.date.isBefore(LocalDate.now())
    var clickable = day.position == DayPosition.MonthDate && isCurrentOrFuture
    var isSelected = day.date.isEqual(selectedDate.value)

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clip(CircleShape)
            .clickable(
                enabled = clickable,
                onClick = {
                    onClick(day)
                    selectedDate.value = day.date
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(spacings.spacingL)
                .background(color = if (isSelected) colors.red3 else Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = day.date.dayOfMonth.toString(),
                color = if (isSelected) colors.white else if (clickable) colors.gray2 else colors.gray4
            )
        }
    }
}