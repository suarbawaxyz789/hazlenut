package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

data class WaypointSearchUiState(
    val isSearchPageActive: Boolean = false,
    val searchQuery: String? = null,
    val filter: CurrentWaypointByStatusFilter = CurrentWaypointByStatusFilter.PENDING,
    val isHasActiveSearch: Boolean = false,
)