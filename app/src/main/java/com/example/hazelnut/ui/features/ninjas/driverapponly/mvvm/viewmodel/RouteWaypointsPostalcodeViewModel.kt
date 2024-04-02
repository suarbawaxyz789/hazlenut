package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.bespoke.ProgressType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.BarValueModel
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.WaypointsGroupByPostcodeModel
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.WaypointModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class RouteWaypointsPostalcodeViewModel @Inject constructor() : ViewModel() {

    private val _routeId = MutableStateFlow(0L)
    val routeId = _routeId.asStateFlow()

    private val _barValues = MutableStateFlow(arrayListOf<BarValueModel>())

    val barValues = _barValues.asStateFlow()

    private val _sequencedWaypointsGroupedByPostCode =
        mutableStateOf(arrayListOf<WaypointsGroupByPostcodeModel>())

    val sequencedWaypointsGroupedByPostCode: State<List<WaypointsGroupByPostcodeModel>> =
        _sequencedWaypointsGroupedByPostCode

    fun setRouteId(routeId: Long) {
        _routeId.value = routeId
    }

    fun testData() {
        _routeId.value = 23982
        _barValues.value = arrayListOf(
            BarValueModel(
                ProgressType.SUCCESS,
                progress = 0.1f,
                "15 successful waypoints",
            ),
            BarValueModel(
                ProgressType.PARTIAL,
                progress = 0.1f, "3 partial waypoints",
            ),
            BarValueModel(
                ProgressType.FAILED,
                progress = 0.1f, "3 failed waypoints",
            ),
            BarValueModel(
                ProgressType.PENDING,
                progress = 0.7f, "1 pending waypoints",
            ),
            BarValueModel(
                ProgressType.NONE,
                progress = 0.7f, "7 waypoints total",
            ),
        )

        _sequencedWaypointsGroupedByPostCode.value = arrayListOf(
            WaypointsGroupByPostcodeModel(
                numOfPickup = 1,
                numOfDelivery = 3,
                postcode = "123456",
                jobListData = listOf(
                    WaypointModel(
                        address = "3 Changi South street 2, Singapore 837484",
                        name = "Butterfly shop",
                        jobListData = listOf(
                            Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111"))
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
                    WaypointModel(
                        address = "3 Changi South street 2, Singapore 837484",
                        name = "Butterfly shop",
                        jobListData = listOf(
                            Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111"))
                        ),
                        enabled = true,
                        jobTags = arrayListOf(
                            JobLabelStyle.PRIOR,
                            JobLabelStyle.COD,
                        ),
                    ),
                    WaypointModel(
                        address = "3 Changi South street 2, Singapore 837484",
                        name = "Butterfly shop",
                        jobListData = listOf(
                            Pair(JobType.PICKUP, listOf("NVSGCTTDR000000111"))
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
            ),
            WaypointsGroupByPostcodeModel(
                numOfPickup = 1,
                numOfDelivery = 3,
                postcode = "123456",
                jobListData = listOf(
                    WaypointModel(
                        address = "3 Changi South street 2, Singapore 837484",
                        name = "Butterfly shop",
                        jobListData = listOf(
                            Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111")),
                            Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111")),
                        ),
                        enabled = true,
                        jobTags = arrayListOf(
                            JobLabelStyle.PRIOR,
                            JobLabelStyle.COD,
                            JobLabelStyle.DOOR_STEP,
                            JobLabelStyle.ID_CHECK
                        )
                    ),
                    WaypointModel(
                        address = "3 Changi South street 2, Singapore 837484",
                        name = "Butterfly shop",
                        jobListData = listOf(
                            Pair(
                                JobType.PICKUP,
                                listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
                            ),
                            Pair(
                                JobType.DELIVERY,
                                listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
                            ),
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
        _barValues.value = ArrayList(_barValues.value).apply {
            addAll(
                arrayListOf(
                    BarValueModel(
                        ProgressType.FAILED,
                        progress = 0.2f, "1 partial waypoints",
                    ),
                    BarValueModel(
                        ProgressType.NONE,
                        progress = 0.3f, "62 waypoints total",
                    ),
                )
            )
        }
        _routeId.value = 23982
    }

}