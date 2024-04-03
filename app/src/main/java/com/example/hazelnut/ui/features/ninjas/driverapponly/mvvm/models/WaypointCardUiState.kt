package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models

import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle

data class WaypointCardUiState(
    val address: String,
    val name: String,
    val jobListData: List<Pair<JobType, List<String>>>,
    val jobTags: List<JobLabelStyle>?,
    val enabled: Boolean,
    val numOfUnscannedParcels : Int? = null,
)

data class WaypointsGroupByPostcodeUiState(
    val postcode: String,
    val numOfDelivery: Int,
    val numOfPickup: Int,
    val jobListData: List<WaypointCardUiState>
)