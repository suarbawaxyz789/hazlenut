package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.bespoke.ProgressType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.BarValueUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobTag
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.MultiColorProgressBarUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.RouteWaypointsPostalCodeActivityUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointFilterUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointsGroupByPostcodeUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointCardUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class RouteWaypointsPostalcodeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<RouteWaypointsPostalCodeActivityUiState>(
        RouteWaypointsPostalCodeActivityUiState.Nothing
    )
    val uiState = _uiState.asStateFlow()

    private val _progressBarUiState = MutableStateFlow(
        MultiColorProgressBarUiState(
            barValues = arrayListOf()
        )
    )

    val progressBarUiState: StateFlow<MultiColorProgressBarUiState> =
        _progressBarUiState.asStateFlow()

    private val _routeId = MutableStateFlow(0L)
    val routeId = _routeId.asStateFlow()

    private val _waypointsFilterOptionVisible = MutableStateFlow(false)
    val waypointsFilterOptionVisible = _waypointsFilterOptionVisible.asStateFlow()

    private val _waypointsFilterActionVisible = MutableStateFlow(false)
    val waypointsFilterActionVisible = _waypointsFilterActionVisible.asStateFlow()

    fun setFilterOptionBottomSheetVisible(visible: Boolean) {
        _waypointsFilterOptionVisible.value = visible
    }

    fun setFilterActionBottomSheetVisible(visible: Boolean) {
        _waypointsFilterActionVisible.value = visible
    }

    private val _waypointsFilter = MutableStateFlow(
        WaypointFilterUiState(
            selectedJobTypes = arrayListOf(),
            selectedTags = arrayListOf(),
        )
    )
    val waypointsFilter = _waypointsFilter.asStateFlow()

    private fun updateActiveFilterStatus() {
        _waypointsFilter.value = _waypointsFilter.value.copy(
            isHasActiveFilter = _waypointsFilter.value.selectedTags.isNotEmpty() || _waypointsFilter.value.selectedJobTypes.isNotEmpty()
        )
    }

    private val _sequencedWaypointsGroupedByPostCode =
        mutableStateOf(arrayListOf<WaypointsGroupByPostcodeUiState>())

    val sequencedWaypointsGroupedByPostCode: State<List<WaypointsGroupByPostcodeUiState>> =
        _sequencedWaypointsGroupedByPostCode

    fun setRouteId(routeId: Long) {
        _routeId.value = routeId
    }

    fun updateFilter(
        selectedJobTypes: List<JobType>? = null,
        selectedTags: List<JobTag>? = null
    ) {
        _waypointsFilter.value = _waypointsFilter.value.copy(
            selectedTags = selectedTags ?: _waypointsFilter.value.selectedTags,
            selectedJobTypes = selectedJobTypes ?: _waypointsFilter.value.selectedJobTypes
        )
        updateActiveFilterStatus()
    }

    fun getWaypoints() {
//         waypointsRepository.getWaypoints.map {
//             // add transformer
//             RouteWaypointsPostalCodeActivityUiState.Success(it)
//        }.stateIn(
//            scope = viewModelScope,
//            initialValue = RouteWaypointsPostalCodeActivityUiState.Progress,
//            started = SharingStarted.WhileSubscribed(5_000),
//        )
    }


    fun testData() {
        _routeId.value = 23982

        _progressBarUiState.update { currentState ->
            currentState.copy(
                barValues = arrayListOf(
                    BarValueUiState(
                        ProgressType.SUCCESS,
                        progress = 0.1f,
                        "15 successful waypoints",
                    ),
                    BarValueUiState(
                        ProgressType.PARTIAL,
                        progress = 0.1f, "3 partial waypoints",
                    ),
                    BarValueUiState(
                        ProgressType.FAILED,
                        progress = 0.1f, "3 failed waypoints",
                    ),
                    BarValueUiState(
                        ProgressType.PENDING,
                        progress = 0.7f, "1 pending waypoints",
                    ),
                    BarValueUiState(
                        ProgressType.NONE,
                        progress = 0.7f, "7 waypoints total",
                    ),
                )
            )
        }

        _sequencedWaypointsGroupedByPostCode.value = arrayListOf(
            WaypointsGroupByPostcodeUiState(
                numOfPickup = 1,
                numOfDelivery = 3,
                postcode = "123456",
                waypoints = listOf(
                    WaypointCardUiState(
                        address = "3 Changi South street 2, Singapore 837484",
                        name = "Butterfly shop",
                        mapTIDByJobType = mapOf(
                            JobType.DELIVERY to listOf("NVSGCTTDR000000111")
                        ),
                        enabled = true,
                        jobTags = arrayListOf(
                            JobLabelStyle.PRIOR,
                            JobLabelStyle.COD,
                            JobLabelStyle.DOOR_STEP,
                            JobLabelStyle.ID_CHECK,
                        ),
                        numOfUnscannedParcels = 4
                    ),
                    WaypointCardUiState(
                        address = "3 Changi South street 2, Singapore 837484",
                        name = "Butterfly shop",
                        mapTIDByJobType = mapOf(
                            JobType.DELIVERY to listOf("NVSGCTTDR000000111")
                        ),
                        enabled = true,
                        jobTags = arrayListOf(
                            JobLabelStyle.PRIOR,
                            JobLabelStyle.COD,
                        ),
                    ),
                    WaypointCardUiState(
                        address = "3 Changi South street 2, Singapore 837484",
                        name = "Butterfly shop",
                        mapTIDByJobType = mapOf(
                            JobType.PICKUP to listOf("NVSGCTTDR000000111")
                        ),
                        enabled = false,
                        jobTags = arrayListOf(
                            JobLabelStyle.PRIOR,
                            JobLabelStyle.COD,
                            JobLabelStyle.DOOR_STEP,
                            JobLabelStyle.ID_CHECK
                        )
                    ),
                ),
            ), WaypointsGroupByPostcodeUiState(
                numOfPickup = 1,
                numOfDelivery = 3,
                postcode = "123456",
                waypoints = listOf(
                    WaypointCardUiState(
                        address = "3 Changi South street 2, Singapore 837484",
                        name = "Butterfly shop",
                        mapTIDByJobType = mapOf(
                            JobType.DELIVERY to listOf("NVSGCTTDR000000111"),
                        ),
                        enabled = true,
                        jobTags = arrayListOf(
                            JobLabelStyle.PRIOR,
                            JobLabelStyle.COD,
                            JobLabelStyle.DOOR_STEP,
                            JobLabelStyle.ID_CHECK
                        )
                    ),
                    WaypointCardUiState(
                        address = "3 Changi South street 2, Singapore 837484",
                        name = "Butterfly shop",
                        mapTIDByJobType = mapOf(
                            JobType.PICKUP to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"),
                            JobType.DELIVERY to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
                        ),
                        enabled = false,
                        jobTags = arrayListOf(
                            JobLabelStyle.PRIOR,
                            JobLabelStyle.COD,
                            JobLabelStyle.DOOR_STEP,
                            JobLabelStyle.ID_CHECK
                        )
                    ),
                ),
            )
        )
    }

    fun test2() {
        _progressBarUiState.update { currentState ->
            currentState.copy(
                ArrayList(_progressBarUiState.value.barValues).apply {
                    addAll(
                        arrayListOf(
                            BarValueUiState(
                                ProgressType.FAILED,
                                progress = 0.2f, "1 partial waypoints",
                            ),
                            BarValueUiState(
                                ProgressType.NONE,
                                progress = 0.3f, "62 waypoints total",
                            ),
                        )
                    )
                }
            )
        }
        _routeId.value = 23982
    }

}