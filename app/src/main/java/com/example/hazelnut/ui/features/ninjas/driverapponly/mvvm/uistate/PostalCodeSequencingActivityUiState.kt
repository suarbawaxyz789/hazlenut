package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

data class PostalCodeSequencingActivityUiState(
    val routeId: Long? = null,
    val appBarUiState: PostcodeSequenceAppBarUiState = PostcodeSequenceAppBarUiState(
        numOfSequencedPostcodes = 0,
        totalPostcodes = 0,
    ),
    val sequencedPostcodesUiState: List<PostcodeCardUiState> = listOf(),
    val unsequencedPostcodesUiState: List<PostcodeCardUiState> = listOf(),
    val addWaypointAt: WaypointToAddLocation? = null,
    val numOfSelectedPostcodes: Int = 0,
    val unsequencedPostcodesSearch: PostcodeSearchUiState = PostcodeSearchUiState()
)

data class PostcodeSequenceAppBarUiState(
    val numOfSequencedPostcodes: Int,
    val totalPostcodes: Int,
)

enum class WaypointToAddLocation {
    TOP,
    BOTTOM,
    MIDDLE,
    ADD_FOR_THE_FIRST_TIME,
}

data class PostcodeSearchUiState(
    val isSearchPageActive: Boolean = false,
    val searchQuery: String? = null,
    val filter: CurrentWaypointByStatusFilter = CurrentWaypointByStatusFilter.PENDING,
    val isHasActiveSearch: Boolean = false,
)