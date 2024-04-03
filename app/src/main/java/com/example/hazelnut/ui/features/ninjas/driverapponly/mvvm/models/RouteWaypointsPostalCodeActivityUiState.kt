package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models

sealed class RouteWaypointsPostalCodeActivityUiState {
    object Nothing: RouteWaypointsPostalCodeActivityUiState()
    object Progress : RouteWaypointsPostalCodeActivityUiState()
    data class Error(val throwable: Throwable?) : RouteWaypointsPostalCodeActivityUiState()
    data class Success<out T>(val value: T) : RouteWaypointsPostalCodeActivityUiState()
}