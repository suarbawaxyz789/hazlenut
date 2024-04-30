package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.postcodesequencing.WaypointToAddLocation
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components.PostcodeSequenceAppBarUiState

data class PostalCodeSequencingActivityUiState(
    val routeId: Long? = null,
    val appBarUiState: PostcodeSequenceAppBarUiState = PostcodeSequenceAppBarUiState(
        numOfSequencedPostcodes = 80,
        totalPostcodes = 3,
    ),
    val postcodesUiState: List<PostcodeCardUiState> = listOf(),
    val addWaypointAt: WaypointToAddLocation? = null,
    val numOfSelectedPostcodes: Int = 0,
)