package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models

import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.JobType

data class WaypointModel(
    val address: String,
    val name: String,
    val jobListData: List<Pair<JobType, List<String>>>,
    val enabled: Boolean,
)

data class WaypointsGroupByPostcodeModel(
    val postcode: String,
    val numOfDelivery: Int,
    val numOfPickup: Int,
    val jobListData: List<WaypointModel>
)