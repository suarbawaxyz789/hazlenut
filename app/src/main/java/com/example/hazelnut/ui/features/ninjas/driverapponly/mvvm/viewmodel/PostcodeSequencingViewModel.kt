package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostalCodeSequencingActivityUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostcodeCardUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.TidWithJobStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ninjavan.swiftninja.mvvm.ui.groupbypostcode.event.PostcodeSequencingEvent
import javax.inject.Inject

class PostcodeSequencingViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(PostalCodeSequencingActivityUiState())
    val uiState = _uiState.asStateFlow()

    fun onUserAction(action: PostcodeSequencingEvent.UserAction) {
        when (action) {
            is PostcodeSequencingEvent.UserAction.SetRouteId -> setRouteId(action.routeId)
            PostcodeSequencingEvent.UserAction.ClearPostcodeSelection -> updatePostcodeSelection(
                deselectAll = true
            )

            is PostcodeSequencingEvent.UserAction.OnPostcodeCardTap -> updatePostcodeSelection(
                action.postcodeUiState
            )

            PostcodeSequencingEvent.UserAction.SelectAllPostcodes -> updatePostcodeSelection(
                selectAll = true
            )
        }
    }

    private fun setRouteId(routeId: Long) {
        _uiState.value = uiState.value.copy(
            routeId = routeId
        )
    }

    private fun updatePostcodeSelection(
        cardUiState: PostcodeCardUiState? = null,
        selectAll: Boolean = false,
        deselectAll: Boolean = false,
    ) {
        _uiState.value = uiState.value.copy(
            sequencedPostcodesUiState = uiState.value.sequencedPostcodesUiState.map {
                if (selectAll) {
                    it.copy(
                        selected = true
                    )
                } else if (deselectAll) {
                    it.copy(
                        selected = false
                    )
                } else {
                    if (it.postcode == cardUiState?.postcode) {
                        it.copy(selected = !it.selected)
                    } else {
                        it
                    }
                }


            }.toList()
        )
        updateNumOfSelectedPostcodes()
    }

    private fun updateNumOfSelectedPostcodes() {
        _uiState.value =
            uiState.value.copy(numOfSelectedPostcodes = uiState.value.sequencedPostcodesUiState.count { it.selected })
    }

    fun testData() {
        _uiState.value = uiState.value.copy(
            sequencedPostcodesUiState = mutableListOf(
                PostcodeCardUiState(
                    postcode = "123456",
                    address = "3 Changi South Street 2, Singapore",
                    mapTIDByJobType = mapOf(
                        JobType.DELIVERY to mutableListOf(
                            TidWithJobStatus(
                                jobStatus = "PENDING", "NVSGCTTDR000000989",
                            )
                        ), JobType.PICKUP to mutableListOf(
                            TidWithJobStatus(
                                jobStatus = "PENDING", "NVSGCTTDR000000888",
                            )
                        )
                    ),
                    enabled = true,
                    jobTags = mutableListOf(JobLabelStyle.PRIOR),
                    numOfBulky = 999,
                    seqNumber = 1,
                    waypointIds = listOf(1, 2, 3)
                ), PostcodeCardUiState(
                    postcode = "234567",
                    address = "3 Changi South Street 2, Singapore",
                    mapTIDByJobType = mapOf(
                        JobType.DELIVERY to mutableListOf(
                            TidWithJobStatus(
                                jobStatus = "PENDING", "NVSGCTTDR000000989",
                            )
                        ), JobType.PICKUP to mutableListOf(
                            TidWithJobStatus(
                                jobStatus = "PENDING", "NVSGCTTDR000000888",
                            )
                        )
                    ),
                    enabled = true,
                    jobTags = mutableListOf(),
                    numOfBulky = 1,
                    seqNumber = 2,
                    waypointIds = listOf(4, 5, 6)
                ), PostcodeCardUiState(
                    postcode = "345678",
                    address = "3 Changi South Street 2, Singapore",
                    mapTIDByJobType = mapOf(
                        JobType.DELIVERY to mutableListOf(
                            TidWithJobStatus(
                                jobStatus = "PENDING", "NVSGCTTDR000000989",
                            )
                        ), JobType.PICKUP to mutableListOf(
                            TidWithJobStatus(
                                jobStatus = "PENDING", "NVSGCTTDR000000888",
                            )
                        )
                    ),
                    enabled = true,
                    jobTags = mutableListOf(JobLabelStyle.PRIOR),
                    numOfBulky = 0,
                    seqNumber = 3,
                    waypointIds = listOf(7, 8, 9)
                )
            )
        )
    }
}