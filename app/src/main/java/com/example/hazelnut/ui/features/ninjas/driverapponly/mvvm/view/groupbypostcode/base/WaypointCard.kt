package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
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
        JobLabelStyle.PRIOR,
        JobLabelStyle.COD,
        JobLabelStyle.ID_CHECK,
        JobLabelStyle.DOOR_STEP
    )

    Column {
        listOfSample.mapIndexed { index, pair ->
            WaypointCard(
                waypointModel = WaypointCardUiState(
                    id = "1",
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
        JobLabelStyle.ID_CHECK,
        JobLabelStyle.DOOR_STEP,
        JobLabelStyle.PRIOR,
        JobLabelStyle.COD,
    )
    Column {
        listOfSample.mapIndexed { index, pair ->
            WaypointCard(
                waypointModel = WaypointCardUiState(
                    id = "1",
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
        JobType.RPU to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"),
        JobType.DELIVERY to listOf(
            "NVSGCTTDR000000111",
            "NVSGCTTDR000000112",
        ),
    )
    val sampleRtsPickup: Map<JobType, List<String>> = mapOf(
        JobType.RTS to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"),
        JobType.PICKUP to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")
    )

    val sampleRtsSinglePickup: Map<JobType, List<String>> = mapOf(
        JobType.PICKUP to listOf("NVSGCTTDR000000111"),
        JobType.RTS to listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"),
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
                    id = "1",
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

@Composable
fun WaypointCard(
    waypointModel: WaypointCardUiState,
    onClick: (() -> Unit)? = null,
) {
    val resources = LocalContext.current.resources
    Column(modifier = Modifier.clickable {
        onClick?.invoke()
    }) {
        Box(
            modifier = Modifier
                .background(color = colors.white)
        ) {
            Column(
                modifier = Modifier
                    .padding(all = spacings.spacingS)
            ) {
                Text(
                    text = waypointModel.address,
                    style = typography.body2.copy(
                        color = if (waypointModel.enabled) colors.gray1 else colors.gray6
                    ),
                )

                Spacer(modifier = Modifier.height(spacings.spacingXs))

                Column {
                    Text(
                        text = waypointModel.name,
                        style = typography.body2Bold.copy(
                            color = if (waypointModel.enabled) colors.gray1 else colors.gray6
                        ),
                    )
                    Spacer(modifier = Modifier.height(spacings.spacingXxxs))
                    Row {
                        Row(modifier = Modifier.weight(1f)) {
                            Column {
                                Row {
                                    waypointModel.mapTIDByJobType.toSortedMap(compareBy { key ->
                                        when (key) {
                                            JobType.DELIVERY -> 1
                                            JobType.RTS -> 2
                                            JobType.RPU -> 3
                                            JobType.PICKUP -> 4
                                        }
                                    }).forEach { pair ->
                                        JobTypeLabel(
                                            type = pair.key,
                                            parcels = pair.value,
                                            isMultipleJobType = waypointModel.mapTIDByJobType.size > 1,
                                            enable = waypointModel.enabled
                                        )
                                    }
                                }
                                waypointModel.numOfUnscannedParcels?.let {
                                    Chip(
                                        shape = RoundedCornerShape(spacings.spacingXxxs),
                                        onClick = {},
                                        colors = ChipDefaults.chipColors(
                                            backgroundColor = colors.red5,
                                            contentColor = colors.red3
                                        ),
                                    ) {
                                        Text(
                                            /// tried pluralStringResource before but not working
                                            text = resources.getQuantityString(
                                                R.plurals.unscanned_parcels_count,
                                                waypointModel.numOfUnscannedParcels,
                                                waypointModel.numOfUnscannedParcels
                                            ),
                                            style = typography.body2.copy(
                                                color = colors.red3
                                            ),
                                        )
                                    }
                                }
                            }
                        }
                        waypointModel.jobTags?.sortedWith(compareBy { value ->
                            when (value) {
                                JobLabelStyle.COD -> 1
                                JobLabelStyle.PRIOR -> 2
                                JobLabelStyle.DOOR_STEP -> 3
                                JobLabelStyle.ID_CHECK -> 4
                                JobLabelStyle.DELIVERY -> 5
                                JobLabelStyle.RPU -> 6
                                JobLabelStyle.OPEN_BOX -> 7
                                JobLabelStyle.CONFIRMED -> 8
                            }
                        })?.let { jobTagList ->
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
                                                end = spacings.spacingXxxs,
                                                bottom = spacings.spacingXxxs
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
                                                    end = spacings.spacingXxxs,
                                                    bottom = spacings.spacingXxxs
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
            color = colors.gray7,
        )
    }
}


@Composable
private fun JobTypeLabel(
    type: JobType,
    parcels: List<String>,
    isMultipleJobType: Boolean,
    enable: Boolean = true
) {
    if (parcels.isEmpty()) return Row {}
    if (isMultipleJobType || parcels.size > 1) {
        return Row(verticalAlignment = Alignment.CenterVertically) {
            IconByJobType(type = type, enable = enable)
            Spacer(modifier = Modifier.width(spacings.spacingXxxs))
            when (type) {
                JobType.DELIVERY -> Text(
                    text = parcels.size.toString(),
                    style = typography.body2.copy(
                        color = if (enable) colors.gray1 else colors.gray5
                    ),
                    maxLines = 1,
                )

                JobType.RTS -> Text(
                    text = stringResource(R.string.num_of_rts_parcels, parcels.size),
                    style = typography.body2.copy(
                        color = if (enable) colors.gray2 else colors.gray5
                    ),
                    maxLines = 1,
                )

                JobType.RPU -> Text(
                    text = stringResource(R.string.num_of_rpu_parcels, parcels.size),
                    style = typography.body2.copy(
                        color = if (enable) colors.gray2 else colors.gray5
                    ),
                    maxLines = 1,
                )

                JobType.PICKUP -> Text(
                    text = parcels.size.toString(),
                    style = typography.body2.copy(
                        color = if (enable) colors.gray1 else colors.gray5
                    ),
                    maxLines = 1,
                )
            }
            Spacer(modifier = Modifier.width(spacings.spacingXxs))
        }
    }

    return Row(verticalAlignment = Alignment.CenterVertically) {
        IconByJobType(type = type, enable = enable)
        Spacer(modifier = Modifier.width(spacings.spacingXxxs))
        when (type) {
            JobType.DELIVERY -> {}
            JobType.RTS -> Row {
                Text(
                    text = stringResource(id = R.string.parcel_rts),
                    style = typography.body2.copy(
                        color = if (enable) colors.gray2 else colors.gray5
                    ),
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(spacings.spacingXxs))
            }

            JobType.RPU -> Row {
                Text(
                    text = stringResource(id = R.string.text_rpu_tag),
                    style = typography.body2.copy(
                        color = if (enable) colors.gray2 else colors.gray5
                    ),
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(spacings.spacingXxs))
            }

            JobType.PICKUP -> {}
        }

        Text(
            text = parcels.first(),
            style = typography.body2.copy(
                color = if (enable) colors.gray3 else colors.gray5
            ),
            maxLines = 1,
        )
    }
}