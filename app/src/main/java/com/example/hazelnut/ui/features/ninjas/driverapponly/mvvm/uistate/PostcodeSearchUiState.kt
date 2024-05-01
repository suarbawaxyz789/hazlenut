package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

data class PostcodeSearchUiState(
    val isSearchPageActive: Boolean = false,
    val searchQuery: String? = null,
    val filter: CurrentWaypointByStatusFilter = CurrentWaypointByStatusFilter.PENDING,
    val isHasActiveSearch: Boolean = false,
)