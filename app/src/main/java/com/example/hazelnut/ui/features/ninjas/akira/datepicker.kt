package com.example.hazelnut.ui.features.ninjas.akira

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.component.drawer.Drawer
import co.ninjavan.akira.designsystem.component.select.Select
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import com.example.hazelnut.ui.features.ninjas.akira.button.ButtonTextLink
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.CalendarView
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CustomDatePicker(
    value: LocalDate,
    onValueChange: (LocalDate) -> Unit
) {

    val open = remember { mutableStateOf(false) }

    if (open.value) {
        CalendarDialog(
            state = rememberUseCaseState(
                visible = true,
                true,
                onCloseRequest = { open.value = false }),
            config = CalendarConfig(
                yearSelection = true,
                style = CalendarStyle.MONTH,
            ),
            selection = CalendarSelection.Date(
                selectedDate = value
            ) { newDate ->
                onValueChange(newDate)
            },
        )
    }

    ButtonTextLink(text = "TEst", onClick = {
        open.value = true
    })

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun CustomDatePickerPreview2() {
    var showSheet = remember { mutableStateOf(false) }

    if (showSheet.value) {
//        BottomSheet() {
//            showSheet.value = false
//        }
    }
    Button(onClick = {
        showSheet.value = true
    }) {
        Text(text = "Show BottomSheet")
    }

}

var showBottomSheetState1 = mutableStateOf(ModalBottomSheetValue.Hidden)
var selectValue1 = mutableStateOf("Text")
var filledState = mutableStateOf(false)

@Preview
@Composable
fun CustomDatePickerPreview3() {
    Surface {
        Column(modifier = Modifier.background(color = colors.gray7).fillMaxSize()) {
            Select(
                text = selectValue1.value,
                labelText = "Label",
                onClick = {
                    toggleDrawer(showBottomSheetState1)
                },
                filled = filledState.value
            )
        }

        SelectDrawer(selectValue1, showBottomSheetState1, filledState)
    }
}

private fun toggleDrawer(state: MutableState<ModalBottomSheetValue>) {
    if (state.value == ModalBottomSheetValue.Hidden) {
        state.value = ModalBottomSheetValue.Expanded
    } else {
        state.value = ModalBottomSheetValue.Hidden
    }
}


@Composable
private fun SelectDrawer(
    selectValue: MutableState<String>,
    state: MutableState<ModalBottomSheetValue>,
    filledState: MutableState<Boolean>
) {

    val date = remember {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mutableStateOf(LocalDate.now())
        } else {
            TODO("VERSION.SDK_INT < O")
        }
    }

    Drawer(
        headerText = "Select Date",
        onStateChanged = { state.value = it },
        showState = state.value,
        forceFullScreen = false,
        skipHalfExpanded = true,
        customHeight = 550.dp,
        content = {
            CalendarView(
                useCaseState = rememberUseCaseState(
                    visible = true,
                    true,
                    onCloseRequest = {
                        /// NOthing
                    }),
                config = CalendarConfig(
                    yearSelection = true,
                    style = CalendarStyle.MONTH,
                ),
                selection = CalendarSelection.Date(
                    selectedDate = date.value
                ) { newDate ->
                    //TODO
                },
            )
        }
    )
}
