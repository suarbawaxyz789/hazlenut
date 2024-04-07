package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle

data class WaypointCardUiState(
    val id : String,
    val address: String,
    val name: String,
    val mapTIDByJobType: Map<JobType, List<String>>,
    val jobTags: List<JobLabelStyle>?,
    val enabled: Boolean,
    val numOfUnscannedParcels : Int? = null,
)

data class WaypointsGroupByPostcodeUiState(
    val postcode: String,
    val numOfDelivery: Int,
    val numOfPickup: Int,
    val waypoints: List<WaypointCardUiState>
)