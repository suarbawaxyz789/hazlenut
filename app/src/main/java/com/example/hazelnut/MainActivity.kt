package com.example.hazelnut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import co.ninjavan.akira.designsystem.component.drawer.Drawer
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
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
                                onWaypointClick = { waypoint ->
//                                    viewModel.toWaypointDetail(waypointId = waypoint.id)
                                }
                            )
                        }
                    }
                }
            }
            WaypointFilterActionBottomSheet(viewModel = viewModel)
            WaypointFilterOptionBottomSheet(viewModel = viewModel)
        }
    }
}

@Composable
fun WaypointFilterOptionBottomSheet(
    viewModel: RouteWaypointsPostalcodeViewModel
) {
    Drawer(
        headerText = stringResource(id = R.string.filter_by),
        onStateChanged = {
            viewModel.setFilterOptionBottomSheetVisible(it)
        },
        showState = viewModel.waypointsFilterOptionVisible.collectAsState().value,
        forceFullScreen = true,
        skipHalfExpanded = true,
        content = {
            var filterState = remember {
                mutableStateOf(viewModel.waypointsFilter.value)
            }
            WaypointsFilterOption(
                filterState,
                onApply = {
                    viewModel.updateFilter(
                        selectedJobTypes = filterState.value.selectedJobTypes,
                        selectedTags = filterState.value.selectedTags,
                    )
                    viewModel.setFilterOptionBottomSheetVisible(ModalBottomSheetValue.Hidden)
                    viewModel.setFilterActionBottomSheetVisible(ModalBottomSheetValue.Hidden)
                },
            )
        }
    )
}

@Composable
fun WaypointFilterActionBottomSheet(
    viewModel: RouteWaypointsPostalcodeViewModel
) {
    Drawer(
        headerText = stringResource(id = R.string.actions),
        onStateChanged = {
            viewModel.setFilterActionBottomSheetVisible(it)
        },
        showState = viewModel.waypointsFilterActionVisible.collectAsState().value,
        forceFullScreen = false,
        skipHalfExpanded = false,
        content = {
            WaypointsFilterAction(
                viewModel.waypointsFilter.collectAsState().value,
                onFilterClick = {
                    viewModel.setFilterOptionBottomSheetVisible(ModalBottomSheetValue.Expanded)
                },
                onParcelStatusClick = {
                    /// TODO
                },
            )
        }
    )
}