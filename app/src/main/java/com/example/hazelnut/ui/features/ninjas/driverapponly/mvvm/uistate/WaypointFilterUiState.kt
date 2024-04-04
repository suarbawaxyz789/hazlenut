package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

data class WaypointFilterUiState(
    val selectedJobTypes: List<JobType>,
    val selectedTags: List<JobTag>,
    val isHasActiveFilter : Boolean = false,
)