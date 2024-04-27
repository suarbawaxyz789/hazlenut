package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

data class RouteStatusesUiState(
    val isRouteStarted: Boolean? = null,
    val isAllVanInbounded: Boolean? = null,
    val isAnyVanInbounded: Boolean? = null,
    val isRouteLocallySequenced: Boolean? = null,
    val isWaypointNeedSequencing: Boolean? = null,
    val waypointPartiallySequenced: Boolean? = null,
    val ctaButtons: List<CTAButton>? = null
)