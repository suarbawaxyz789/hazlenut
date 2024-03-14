package com.example.hazelnut.ui.features.ninjas.akira.calendarpicker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.component.divider.DividerMedium
import co.ninjavan.akira.designsystem.component.drawer.Drawer
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.R
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.daysOfWeek
import java.time.LocalDate
import java.time.YearMonth

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun CustomDatePickerPreview() {
    Surface {
        Box(modifier = Modifier.padding(all = spacings.spacingXs)) {
            Column {
                Text(
                    text = "Selected date : ${selectedDateState.value}",
                    style = AkiraTheme.typography.body1.copy(
                        color = colors.blue3
                    )
                )
                Spacer(modifier = Modifier.height(40.dp))
                Column(
                    modifier = Modifier
                        .background(color = colors.white)
                ) {
                    CalendarPickerInput(selectValue, filledState)
                }
            }
        }
        CalendarPickerDrawer(
            showBottomSheetState,
            selectedDateState = selectedDateState,
            onClick = {
                selectValue.value = it.date.toString()
            })
    }
}

var showBottomSheetState = mutableStateOf(ModalBottomSheetValue.Hidden)
var selectValue = mutableStateOf("")
var filledState = mutableStateOf(false)

@RequiresApi(Build.VERSION_CODES.O)
var selectedDateState = mutableStateOf(LocalDate.now())

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarPickerInput(selectedValue: MutableState<String>, filledState: MutableState<Boolean>) {
    Select(
        text = selectedValue.value,
        onClick = {
            toggleDrawer(showBottomSheetState)
        },
        filled = filledState.value
    )
}

private fun toggleDrawer(state: MutableState<ModalBottomSheetValue>) {
    if (state.value == ModalBottomSheetValue.Hidden) {
        state.value = ModalBottomSheetValue.Expanded
    } else {
        state.value = ModalBottomSheetValue.Hidden
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun CalendarPickerDrawer(
    state: MutableState<ModalBottomSheetValue>,
    selectedDateState: MutableState<LocalDate>,
    onClick: (CalendarDay) -> Unit
) {
    val currentMonth = remember { YearMonth.now() }
    val startMonth = remember { currentMonth.minusMonths(100) }
    val endMonth = remember { currentMonth.plusMonths(100) }
    val daysOfWeek = daysOfWeek()

    val monthState = rememberCalendarState(
        firstVisibleMonth = currentMonth,
        startMonth = startMonth,
        endMonth = endMonth,
        firstDayOfWeek = daysOfWeek.first()
    )

    Drawer(
        headerText = "Select Date",
        onStateChanged = { state.value = it },
        showState = state.value,
        forceFullScreen = false,
        skipHalfExpanded = true,
        customHeight = 500.dp,
        content = {
            CalendarPicker(
                state = monthState,
                selectedDate = selectedDateState,
                onClick = onClick
            )
        }
    )
}


@Composable
private fun Select(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    filled: Boolean = false,
    enabled: Boolean = true,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val colorSelector =
        if (!enabled) colors.gray4 else colors.gray2
    val textColorSelector =
        if (!enabled) colors.gray4 else if (filled) colors.gray2 else colors.gray3
    val clickModifier = if (enabled) modifier.then(
        Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .fillMaxWidth()
    ) else Modifier.fillMaxWidth()
    Column(
        modifier = clickModifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier
                    .padding(start = spacings.spacingXxs)
                    .size(spacings.spacingXs),
                painter = painterResource(id = R.drawable.icon_l_calendar_alt),
                tint = colorSelector,
                contentDescription = null // decorative element
            )
            Spacer(modifier = Modifier.width(spacings.spacingXxxs))
            Text(
                text = text, style = AkiraTheme.typography.body1, color = textColorSelector,
                modifier = Modifier.weight(1f)
            )
            Icon(
                modifier = Modifier
                    .padding(start = spacings.spacingXxs)
                    .size(spacings.spacingXs)
                    .rotate(90f),
                painter = painterResource(id = R.drawable.angle_right),
                tint = colorSelector,
                contentDescription = null // decorative element
            )
        }
        DividerMedium()
    }
}