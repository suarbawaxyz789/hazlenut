package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabel
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointCardUiState
import ninjavan.swiftninja.mvvm.ui.groupbypostcode.base.JobTypeLabel

@Preview
@Composable
private fun WaypointCardSinglePreview() {
    var sample1Delivery: Map<JobType, List<JobUiState>> =
        mapOf(JobType.DELIVERY to listOf(JobUiState("SUCCESS", "NVSGCTTDR000000111")))
    val sample1Pickup: Map<JobType, List<JobUiState>> = mapOf(
        JobType.PICKUP to listOf(JobUiState("SUCCESS", "NVSGCTTDR000000111"))
    )

    val sample1RPU: Map<JobType, List<JobUiState>> = mapOf(
        JobType.RPU to listOf(JobUiState("SUCCESS", "NVSGCTTDR000000111"))
    )

    val sample1RTS: Map<JobType, List<JobUiState>> = mapOf(
        JobType.RTS to listOf(JobUiState("SUCCESS", "NVSGCTTDR000000111"))
    )
    var listOfSample =
        arrayListOf(
            sample1Delivery,
            sample1Pickup,
            sample1RPU,
            sample1RTS,
        )

    var tags = arrayListOf(
        JobLabelStyle.PRIOR,
        JobLabelStyle.COD,
        JobLabelStyle.ID_CHECK,
        JobLabelStyle.DOOR_STEP
    )

    Column {
        listOfSample.mapIndexed { index, pair ->
            WaypointCard(
                waypointModel = WaypointCardUiState(
                    address = "3 Changi South street 2, Singapore 837484",
                    mapTIDByJobType = pair,
                    name = "Butterfly shop",
                    enabled = true,
                    jobTags = tags.take(index + 1),
                    numOfUnscannedParcels = 2,
                ),
            )
        }
    }
}

@Preview
@Composable
private fun WaypointCardMultiPreview() {
    val sampleMultiDelivery: Map<JobType, List<JobUiState>> = mapOf(
        JobType.DELIVERY to listOf(
            JobUiState("SUCCESS", "NVSGCTTDR000000111"),
            JobUiState("SUCCESS", "NVSGCTTDR000000112")
        )
    )

    val sampleMultiPickup: Map<JobType, List<JobUiState>> = mapOf(
        JobType.PICKUP to listOf(
            JobUiState("SUCCESS", "NVSGCTTDR000000111"),
            JobUiState("SUCCESS", "NVSGCTTDR000000112")
        )
    )

    val sampleMultiRPU: Map<JobType, List<JobUiState>> = mapOf(
        JobType.RPU to listOf(
            JobUiState("SUCCESS", "NVSGCTTDR000000111"),
            JobUiState("SUCCESS", "NVSGCTTDR000000112")
        )
    )

    val sampleMultiRTS: Map<JobType, List<JobUiState>> = mapOf(
        JobType.RTS to listOf(
            JobUiState("SUCCESS", "NVSGCTTDR000000111"),
            JobUiState("SUCCESS", "NVSGCTTDR000000112")
        )
    )

    var listOfSample =
        arrayListOf(
            sampleMultiDelivery,
            sampleMultiPickup,
            sampleMultiRPU,
            sampleMultiRTS,
        )

    var tags = arrayListOf(
        JobLabelStyle.ID_CHECK,
        JobLabelStyle.DOOR_STEP,
        JobLabelStyle.PRIOR,
        JobLabelStyle.COD,
    )
    Column {
        listOfSample.mapIndexed { index, pair ->
            WaypointCard(
                waypointModel = WaypointCardUiState(
                    address = "3 Changi South street 2, Singapore 837484",
                    mapTIDByJobType = pair,
                    name = "Butterfly shop",
                    enabled = true,
                    jobTags = tags.take(index + 1),
                ),
            )
        }
    }
}


@Preview
@Composable
private fun WaypointCardMixPreview() {
    var sampleDeliveryRpu: Map<JobType, List<JobUiState>> = mapOf(
        JobType.RPU to listOf(
            JobUiState("SUCCESS", "NVSGCTTDR000000111"),
            JobUiState("SUCCESS", "NVSGCTTDR000000112")
        ),
        JobType.DELIVERY to listOf(
            JobUiState("SUCCESS", "NVSGCTTDR000000111"),
            JobUiState("SUCCESS", "NVSGCTTDR000000112"),
        ),
    )
    val sampleRtsPickup: Map<JobType, List<JobUiState>> = mapOf(
        JobType.RTS to listOf(
            JobUiState(
                "SUCCESS",
                "NVSGCTTDR000000111"
            ),
            JobUiState(
                "SUCCESS", "NVSGCTTDR000000112"
            )
        ),
        JobType.PICKUP to listOf(
            JobUiState(
                "SUCCESS",
                "NVSGCTTDR000000111"
            ),
            JobUiState(
                "SUCCESS", "NVSGCTTDR000000112"
            )
        )
    )

    val sampleRtsSinglePickup: Map<JobType, List<JobUiState>> = mapOf(
        JobType.PICKUP to listOf(
            JobUiState(
                jobStatus = "SUCCESS",
                trackingId = "NVSGCTTDR000000111"
            )
        ),
        JobType.RTS to listOf(
            JobUiState(jobStatus = "SUCCESS", trackingId = "NVSGCTTDR000000111"),
            JobUiState("SUCCESS", "NVSGCTTDR000000112")
        ),
    )

    var listOfSample =
        arrayListOf(
            sampleDeliveryRpu,
            sampleRtsPickup,
            sampleRtsSinglePickup,
        )

    var tags = arrayListOf(
        JobLabelStyle.PRIOR,
        JobLabelStyle.COD,
        JobLabelStyle.ID_CHECK,
        JobLabelStyle.DOOR_STEP
    )

    Column {
        listOfSample.mapIndexed { index, pair ->
            WaypointCard(
                waypointModel = WaypointCardUiState(
                    address = "3 Changi South street 2, Singapore 837484",
                    mapTIDByJobType = pair,
                    name = "Butterfly shop",
                    enabled = true,
                    jobTags = tags.take(index + 1),
                    numOfUnscannedParcels = 12,
                ),
            )
        }
    }
}

@Preview
@Composable
private fun WaypointCardRtsNoParcels() {
    WaypointCard(
        waypointModel = WaypointCardUiState(
            address = "success return pickup parcel, RPU parcel",
            enabled = true,
            name = "TEST-LERI-SHIPPER",
            numOfUnscannedParcels = 0,
            jobTags = mutableListOf(),
            mapTIDByJobType = mutableMapOf(),
        )
    )
}

@Composable
fun WaypointCard(
    waypointModel: WaypointCardUiState,
    onClick: (() -> Unit)? = null,
) {
    val resources = LocalContext.current.resources
    Column(modifier = if (waypointModel.enabled) Modifier.clickable {
        onClick?.invoke()
    } else Modifier) {
        Box(
            modifier = Modifier
                .background(color = AkiraTheme.colors.white)
        ) {
            Column(
                modifier = Modifier
                    .padding(all = AkiraTheme.spacings.spacingS)
            ) {
                Text(
                    text = waypointModel.address,
                    style = AkiraTheme.typography.body2.copy(
                        color = if (waypointModel.enabled) AkiraTheme.colors.gray1 else AkiraTheme.colors.gray6
                    ),
                )

                Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXs))

                Column {
                    Text(
                        text = waypointModel.name,
                        style = AkiraTheme.typography.body2Bold.copy(
                            color = if (waypointModel.enabled) AkiraTheme.colors.gray1 else AkiraTheme.colors.gray6
                        ),
                    )
                    Spacer(modifier = Modifier.height(AkiraTheme.spacings.spacingXxxs))
                    Row {
                        Row(modifier = Modifier.weight(1f)) {
                            Column {
                                Row {
                                    waypointModel.mapTIDByJobType.forEach { pair ->
                                        JobTypeLabel(
                                            type = pair.key,
                                            parcels = pair.value,
                                            isMultipleJobType = waypointModel.mapTIDByJobType.size > 1,
                                            enable = waypointModel.enabled
                                        )
                                    }
                                }
                                if (waypointModel.numOfUnscannedParcels != null && waypointModel.numOfUnscannedParcels > 0) {
                                    Chip(
                                        shape = RoundedCornerShape(AkiraTheme.spacings.spacingXxxs),
                                        onClick = {},
                                        colors = ChipDefaults.chipColors(
                                            backgroundColor = AkiraTheme.colors.red5,
                                            contentColor = AkiraTheme.colors.red3
                                        ),
                                    ) {
                                        Text(
                                            /// tried pluralStringResource before but not working
                                            text = resources.getQuantityString(
                                                R.plurals.unscanned_parcels_count,
                                                waypointModel.numOfUnscannedParcels,
                                                waypointModel.numOfUnscannedParcels
                                            ),
                                            style = AkiraTheme.typography.body2.copy(
                                                color = AkiraTheme.colors.red3
                                            ),
                                        )
                                    }
                                }
                            }
                        }
                        waypointModel.jobTags?.let { jobTagList ->
                            /// this can be simplified later using FlowRow but need to add foundation:1.4.3
                            Column(horizontalAlignment = Alignment.End) {
                                Row {
                                    jobTagList.take(2).sortedWith(compareBy { value ->
                                        when (value) {
                                            JobLabelStyle.PRIOR -> 2
                                            else -> {
                                                1
                                            }
                                        }
                                    }).map { jobTag ->
                                        JobLabel(
                                            tagStyle = jobTag,
                                            modifier = Modifier.padding(
                                                end = AkiraTheme.spacings.spacingXxxs,
                                                bottom = AkiraTheme.spacings.spacingXxxs
                                            ),
                                            enable = waypointModel.enabled,
                                        )
                                    }
                                }
                                if (waypointModel.jobTags.size > 2) {
                                    Row {
                                        jobTagList.slice(2 until jobTagList.size).map { jobTag ->
                                            JobLabel(
                                                tagStyle = jobTag,
                                                modifier = Modifier.padding(
                                                    end = AkiraTheme.spacings.spacingXxxs,
                                                    bottom = AkiraTheme.spacings.spacingXxxs
                                                ),
                                                enable = waypointModel.enabled,
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        Divider(
            color = AkiraTheme.colors.gray7,
        )
    }
}