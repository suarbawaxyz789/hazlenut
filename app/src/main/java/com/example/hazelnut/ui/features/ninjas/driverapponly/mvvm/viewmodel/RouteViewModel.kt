package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hazelnut.ui.features.ninjas.bespoke.ProgressType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.BarValueModel
import javax.inject.Inject

class RouteViewModel @Inject constructor() : ViewModel() {
    private val _routeId = mutableStateOf("")
    val routeId: State<String> = _routeId

    private val _barValues = mutableStateOf(arrayListOf<BarValueModel>())

    val barValues: State<List<BarValueModel>> = _barValues

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
    }

}