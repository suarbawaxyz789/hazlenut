package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

data class PostalCodeSequencingActivityUiState(
    val routeId: Long? = null,
    val appBarUiState: PostcodeSequenceAppBarUiState = PostcodeSequenceAppBarUiState(
        numOfSequencedPostcodes = 80,
        totalPostcodes = 3,
    ),
    val sequencedPostcodesUiState: List<PostcodeCardUiState> = listOf(),
    val unsequencedPostcodesUiState: List<PostcodeCardUiState> = listOf(),
    val addWaypointAt: WaypointToAddLocation? = null,
    val numOfSelectedPostcodes: Int = 0,
    val unsequencedPostcodesSearch: PostcodeSearchUiState = PostcodeSearchUiState()
)

enum class WaypointToAddLocation {
    TOP,
    BOTTOM,
    MIDDLE,
}

data class PostcodeSequenceAppBarUiState(
    val numOfSequencedPostcodes: Int,
    val totalPostcodes: Int,
)

data class PostcodeSearchUiState(
    val isSearchPageActive: Boolean = false,
    val searchQuery: String? = null,
    val filter: CurrentWaypointByStatusFilter = CurrentWaypointByStatusFilter.PENDING,
    val isHasActiveSearch: Boolean = false,
)