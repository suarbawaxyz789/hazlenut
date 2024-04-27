package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

enum class JobType {
    DELIVERY,
    RTS,
    RPU,
    PICKUP
}

enum class JobTag {
    PRIOR,
    COD,
    DOORSTEP,
    ID_CHECK
}

enum class CurrentWaypointByStatusFilter {
    PENDING,
    PARTIAL,
    SUCCESSFUL,
    FAILED,
    ALL,
}

enum class CTAButton {
    SCAN_UNSCANNED_PARCELS,
    CONTINUE_SEQUENCING,
    UPDATE_SEQUENCE,
    START_SEQUENCING,
    CHANGE_SEQUENCE,
    START_SCANNING,
    START_ROUTE,
    SCAN_PARCELS,
}