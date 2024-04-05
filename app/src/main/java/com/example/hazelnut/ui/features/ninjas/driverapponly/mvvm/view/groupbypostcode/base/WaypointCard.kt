package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabel
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointCardUiState

@Preview
@Composable
private fun WaypointCardSinglePreview() {
    var sample1Delivery: Map<JobType, List<String>> =
        mapOf(JobType.DELIVERY to listOf("NVSGCTTDR000000111"))
    val sample1Pickup: Map<JobType, List<String>> = mapOf(
        JobType.PICKUP to listOf("NVSGCTTDR000000111")
    )

    val sample1RPU: Map<JobType, List<String>> = mapOf(
        JobType.RPU to listOf("NVSGCTTDR000000111")
    )

    val sample1RTS: Map<JobType, List<String>> = mapOf(
        JobType.RTS to listOf("NVSGCTTDR000000111")
    )
    var listOfSample =
        arrayListOf(
            sample1Delivery,
            sample1Pickup,
            sample1RPU,
            sample1RTS,
        )

    var tags = arrayListOf(
        JobLabelStyle.COD,
        JobLabelStyle.PRIOR,
        JobLabelStyle.DOOR_STEP,
        JobLabelStyle.ID_CHECK
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
    val sampleMultiDelivery: Map<JobType, List<String>> = mapOf(
        JobType.DELIVERY to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
    )

    val sampleMultiPickup: Map<JobType, List<String>> = mapOf(
        JobType.PICKUP to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
    )

    val sampleMultiRPU: Map<JobType, List<String>> = mapOf(
        JobType.RPU to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
    )

    val sampleMultiRTS: Map<JobType, List<String>> = mapOf(
        JobType.RTS to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
    )

    var listOfSample =
        arrayListOf(
            sampleMultiDelivery,
            sampleMultiPickup,
            sampleMultiRPU,
            sampleMultiRTS,
        )

    var tags = arrayListOf(
        JobLabelStyle.COD,
        JobLabelStyle.PRIOR,
        JobLabelStyle.DOOR_STEP,
        JobLabelStyle.ID_CHECK
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
    var sampleDeliveryRpu: Map<JobType, List<String>> = mapOf(
        JobType.DELIVERY to listOf(
            "NVSGCTTDR000000111",
            "NVSGCTTDR000000112",
        ),
        JobType.RPU to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
    )
    val sampleRtsPickup: Map<JobType, List<String>> = mapOf(
        JobType.RTS to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"),
        JobType.PICKUP to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
    )

    val sampleRtsSinglePickup: Map<JobType, List<String>> = mapOf(
        JobType.RTS to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"),
        JobType.PICKUP to listOf("NVSGCTTDR000000111")
    )

    var listOfSample =
        arrayListOf(
            sampleDeliveryRpu,
            sampleRtsPickup,
            sampleRtsSinglePickup,
        )

    var tags = arrayListOf(
        JobLabelStyle.COD,
        JobLabelStyle.PRIOR,
        JobLabelStyle.DOOR_STEP,
        JobLabelStyle.ID_CHECK
    )

    Column {
        listOfSample.mapIndexed { index, pair ->
            WaypointCard(
                waypointModel = WaypointCardUiState(
                    address = "3 Changi South street 2, Singapore 837484",
                    mapTIDByJobType = pair,
                    name = "Butterfly shop",
                    enabled = true,
                    jobTags = arrayListOf(
                        JobLabelStyle.COD,
                        JobLabelStyle.PRIOR,
                        JobLabelStyle.DOOR_STEP,
                        JobLabelStyle.ID_CHECK
                    ),
                    numOfUnscannedParcels = 12,
                ),
            )
        }
    }
}

@Composable
fun WaypointCard(
    waypointModel: WaypointCardUiState,
) {
    val resources = LocalContext.current.resources
    Column {
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
                                if (waypointModel.mapTIDByJobType != null) {
                                    Row {
                                        waypointModel.mapTIDByJobType.forEach { pair ->
                                            JobTypeLabel(
                                                type = pair.key,
                                                parcels = pair.value,
                                                isMix = waypointModel.mapTIDByJobType.size > 1,
                                                enable = waypointModel.enabled
                                            )
                                        }
                                    }
                                }
                                waypointModel.numOfUnscannedParcels?.let {
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
                                    jobTagList.take(2).map { jobTag ->
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

@Composable
private fun JobTypeLabel(
    type: JobType,
    parcels: List<String>,
    isMix: Boolean,
    enable: Boolean = true
) {
    if (parcels.isEmpty()) return Row {}
    if (isMix || parcels.size > 1) {
        return Row(verticalAlignment = Alignment.CenterVertically) {
            IconByJobType(type = type, enable = enable)
            Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxxs))
            when (type) {
                JobType.DELIVERY -> Text(
                    text = parcels.size.toString(),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray1 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )

                JobType.RTS -> Text(
                    text = stringResource(R.string.num_of_rts_parcels, parcels.size),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )

                JobType.RPU -> Text(
                    text = stringResource(R.string.num_of_rpu_parcels, parcels.size),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )

                JobType.PICKUP -> Text(
                    text = parcels.size.toString(),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray1 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )
            }
            Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
        }
    }

    return Row(verticalAlignment = Alignment.CenterVertically) {
        IconByJobType(type = type, enable = enable)
        Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxxs))
        when (type) {
            JobType.DELIVERY -> {}
            JobType.RTS -> Row {
                Text(
                    text = stringResource(id = R.string.parcel_rts),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
            }

            JobType.RPU -> Row {
                Text(
                    text = stringResource(id = R.string.text_rpu_tag),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
            }

            JobType.PICKUP -> {}
        }

        Text(
            text = parcels.first(),
            style = AkiraTheme.typography.body2.copy(
                color = if (enable) AkiraTheme.colors.gray3 else AkiraTheme.colors.gray5
            ),
            maxLines = 1,
        )
    }
}