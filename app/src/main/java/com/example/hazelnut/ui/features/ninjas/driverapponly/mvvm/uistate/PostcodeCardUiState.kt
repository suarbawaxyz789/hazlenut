package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle

data class PostcodeCardUiState(
    val postcode: String,
    val address: String,
    val mapTIDByJobType: Map<JobType, List<TidWithJobStatus>>,
    val numOfBulky: Int,
    val seqNumber: Int,
    val enabled: Boolean,
    val selected: Boolean = false,
    val jobTags: List<JobLabelStyle>?,
    val waypointIds: List<Long>,
)