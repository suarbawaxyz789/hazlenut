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
import javax.inject.Inject

class RouteWaypointsPostalcodeViewModel @Inject constructor() : ViewModel() {
    private val _routeId = mutableStateOf("")
    val routeId: State<String> = _routeId

    private val _barValues = mutableStateOf(arrayListOf<BarValueModel>())

    val barValues: State<List<BarValueModel>> = _barValues

    private val _sequencedWaypointsGroupedByPostCode =
        mutableStateOf(arrayListOf<WaypointsGroupByPostcodeModel>())

    val sequencedWaypointsGroupedByPostCode: State<List<WaypointsGroupByPostcodeModel>> =
        _sequencedWaypointsGroupedByPostCode

    fun testData() {
        _routeId.value = "12346"
        _barValues.value = arrayListOf(
            BarValueModel(
                ProgressType.SUCCESS,
                progress = 0.1f,
                "15 successful waypoints",
            ),
            BarValueModel(
                ProgressType.PENDING,
                progress = 0.1f, "54 pending waypoints",
            ),
            BarValueModel(
                ProgressType.PARTIAL,
                progress = 0.1f, "1 partial waypoints",
            ),
            BarValueModel(
                ProgressType.FAILED,
                progress = 0.2f, "1 partial waypoints",
            ),
            BarValueModel(
                ProgressType.NONE,
                progress = 0.3f, "62 waypoints total",
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
                        numOfUnscannedParcels = 0,
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
                        ),
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
                            Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111"))
                        ),
                        enabled = true,
                        jobTags = arrayListOf(
                            JobLabelStyle.PRIOR,
                            JobLabelStyle.COD,
                            JobLabelStyle.DOOR_STEP,
                            JobLabelStyle.ID_CHECK
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
                        ),
                    ),
                ),
            )
        )
    }

}