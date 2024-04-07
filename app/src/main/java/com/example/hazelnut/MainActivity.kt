package com.example.hazelnut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components.RouteFloatingActionButton
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components.RoutePageAppBar
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components.WaypointsFilterAction
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components.WaypointsFilterOption
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components.WaypointsGroupByPostcode
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel.RouteWaypointsPostalcodeViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: RouteWaypointsPostalcodeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.testData()
        viewModel.setRouteId(123456)

        setContent {
            Content(viewModel = viewModel)
        }
    }
}

@Composable
private fun Content(viewModel: RouteWaypointsPostalcodeViewModel) {

    if (viewModel.waypointsFilterOptionVisible.collectAsState().value) {
        WaypointFilterOptionBottomSheet(viewModel = viewModel) {
            viewModel.setFilterOptionBottomSheetVisible(false)
        }
    }

    if (viewModel.waypointsFilterActionVisible.collectAsState().value) {
        WaypointFilterActionBottomSheet(viewModel = viewModel) {
            viewModel.setFilterActionBottomSheetVisible(false)
        }
    }

    AkiraTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Scaffold(
                    floatingActionButton = {
                        RouteFloatingActionButton(viewModel = viewModel)
                    },
                    topBar = {
                        RoutePageAppBar(
                            viewModel = viewModel,
                            progressBarUiState = viewModel.progressBarUiState.collectAsState().value
                        )
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(innerPadding)
                    ) {
                        viewModel.sequencedWaypointsGroupedByPostCode.value.map { waypointsGroup ->
                            WaypointsGroupByPostcode(
                                waypointsGroupModel = waypointsGroup,
                                onWaypointClick = {
                                    waypoint -> viewModel.toWaypointDetail(waypointId = waypoint.id)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaypointFilterOptionBottomSheet(
    viewModel: RouteWaypointsPostalcodeViewModel,
    onDismiss: () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.HiddenShape },
        shape = RoundedCornerShape(
            topStart = spacings.spacingXxs,
            topEnd = spacings.spacingXxs,
        ),
    ) {
        var filterState = remember {
            mutableStateOf(viewModel.waypointsFilter.value)
        }
        WaypointsFilterOption(
            filterState,
            onClose = {
                viewModel.setFilterOptionBottomSheetVisible(false)
            },
            onApply = {
                viewModel.updateFilter(
                    selectedJobTypes = filterState.value.selectedJobTypes,
                    selectedTags = filterState.value.selectedTags,
                )
                viewModel.setFilterOptionBottomSheetVisible(false)
                viewModel.setFilterActionBottomSheetVisible(false)
            },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaypointFilterActionBottomSheet(
    viewModel: RouteWaypointsPostalcodeViewModel,
    onDismiss: () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.HiddenShape },
        shape = RoundedCornerShape(
            topStart = spacings.spacingXxs,
            topEnd = spacings.spacingXxs,
        ),
    ) {
        WaypointsFilterAction(
            viewModel.waypointsFilter.collectAsState().value,
            onFilterClick = {
                viewModel.setFilterOptionBottomSheetVisible(true)
            },
            onParcelStatusClick = {
                /// TODO
            },
            onClose = {
                viewModel.setFilterActionBottomSheetVisible(false)
            },
        )
    }
}