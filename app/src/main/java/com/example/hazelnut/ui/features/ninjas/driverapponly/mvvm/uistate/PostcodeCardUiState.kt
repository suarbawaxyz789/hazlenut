package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate

import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle

data class PostcodeCardUiState(
    val postcode: String,
    val address: String,
    val mapTIDByJobType: Map<JobType, List<JobUiState>>,
    val numOfBulky: Int,
    val seqNumber: Int,
    val enabled: Boolean,
    val jobTags: List<JobLabelStyle>?,
)