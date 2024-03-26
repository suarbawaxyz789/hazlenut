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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabel
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.WaypointModel

@Preview
@Composable
private fun WaypointCardSinglePreview() {
    var sample1Delivery: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111"))
    )
    var sample1Pickup: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.PICKUP, listOf("NVSGCTTDR000000111"))
    )
    var sample1RPU: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.RPU, listOf("NVSGCTTDR000000111"))
    )
    var sample1RTS: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.RTS, listOf("NVSGCTTDR000000111"))
    )
    var listOfSample =
        arrayListOf(
            sample1Delivery,
            sample1Pickup,
            sample1RPU,
            sample1RTS,
        )

    Column {
        listOfSample.map {
            WaypointCard(
                waypointModel = WaypointModel(
                    address = "3 Changi South street 2, Singapore 837484",
                    jobListData = it,
                    name = "Butterfly shop",
                    enabled = true,
                    jobTags = arrayListOf(
                        JobLabelStyle.COD,
                    ),
                    numOfUnscannedParcels = 2,
                ),
            )
        }
    }
}

@Preview
@Composable
private fun WaypointCardMultiPreview() {
    var sampleMultiDelivery: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
    )
    var sampleMultiPickup: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.PICKUP, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
    )
    var sampleMultiRPU: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.RPU, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
    )
    var sampleMultiRTS: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.RTS, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
    )

    var listOfSample =
        arrayListOf(
            sampleMultiDelivery,
            sampleMultiPickup,
            sampleMultiRPU,
            sampleMultiRTS,
        )

    Column {
        listOfSample.map {
            WaypointCard(
                waypointModel = WaypointModel(
                    address = "3 Changi South street 2, Singapore 837484",
                    jobListData = it,
                    name = "Butterfly shop",
                    enabled = true,
                    jobTags = arrayListOf(
                        JobLabelStyle.COD,
                        JobLabelStyle.PRIOR,
                        JobLabelStyle.DOOR_STEP,
                    ),
                ),
            )
        }
    }
}


@Preview
@Composable
private fun WaypointCardMixPreview() {
    var sampleDeliveryRpu: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")),
        Pair(JobType.RPU, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
    )
    var sampleRtsPickup: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.RTS, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")),
        Pair(JobType.PICKUP, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
    )

    var listOfSample =
        arrayListOf(
            sampleDeliveryRpu,
            sampleRtsPickup,
        )

    Column {
        listOfSample.map {
            WaypointCard(
                waypointModel = WaypointModel(
                    address = "3 Changi South street 2, Singapore 837484",
                    jobListData = it,
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
    waypointModel: WaypointModel,
) {
    Column {
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
                    style = AkiraTheme.typography.body2.copy(
                        color = if (waypointModel.enabled) colors.gray1 else colors.gray6
                    ),
                )

                Spacer(modifier = Modifier.height(spacings.spacingXs))

                Column {
                    Text(
                        text = waypointModel.name,
                        style = AkiraTheme.typography.body2Bold.copy(
                            color = if (waypointModel.enabled) colors.gray1 else colors.gray6
                        ),
                    )
                    Spacer(modifier = Modifier.height(spacings.spacingXxxs))
                    Row {
                        Row(modifier = Modifier.weight(1f)) {
                            Column {
                                if (waypointModel.jobListData != null) {
                                    Row {
                                        waypointModel.jobListData.forEach { pair ->
                                            JobTypeLabel(
                                                type = pair.first,
                                                parcels = pair.second
                                            )
                                        }
                                    }
                                }
                                waypointModel.numOfUnscannedParcels?.let {
                                    Chip(
                                        shape = RoundedCornerShape(spacings.spacingXxxs),
                                        onClick = { /*TODO*/ },
                                        colors = ChipDefaults.chipColors(
                                            backgroundColor = colors.red5,
                                            contentColor = colors.red3
                                        ),
                                    ) {
                                        Text(
                                            text = "${waypointModel.numOfUnscannedParcels} parcel to scan",
                                            style = AkiraTheme.typography.body2.copy(
                                                color = colors.red3
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
private fun JobTypeLabel(type: JobType, parcels: List<String>, enable: Boolean = true) {
    if (parcels.isEmpty()) return Row {}
    if (parcels.size == 1) {
        return Row(verticalAlignment = Alignment.CenterVertically) {
            IconByJobType(type = type, enable = enable)
            Spacer(modifier = Modifier.width(spacings.spacingXxs))
            if (type == JobType.RTS) {
                Text(
                    text = stringResource(id = R.string.parcel_rts),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) colors.gray2 else colors.gray5
                    ),
                    maxLines = 1,
                )
            }
            if (type == JobType.RPU) {
                Text(
                    text = stringResource(id = R.string.tag_rpu),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) colors.gray2 else colors.gray5
                    ),
                    maxLines = 1,
                )
            }
            Spacer(modifier = Modifier.width(spacings.spacingXxs))
            Text(
                text = parcels.first(),
                style = AkiraTheme.typography.body2.copy(
                    color = if (enable) colors.gray3 else colors.gray5
                ),
                maxLines = 1,
            )
        }
    }

    return Row(verticalAlignment = Alignment.CenterVertically) {
        IconByJobType(type = type, enable = enable)
        Spacer(modifier = Modifier.width(spacings.spacingXxs))
        Text(
            text = parcels.size.toString(),
            style = AkiraTheme.typography.body2.copy(
                color = if (enable) colors.gray1 else colors.gray5
            ),
            maxLines = 1,
        )
        Spacer(modifier = Modifier.width(spacings.spacingXxs))
        if (type == JobType.RTS) {
            Text(
                text = stringResource(id = R.string.parcel_rts),
                style = AkiraTheme.typography.body2.copy(
                    color = if (enable) colors.gray2 else colors.gray5
                ),
                maxLines = 1,
            )
        }
        if (type == JobType.RPU) {
            Text(
                text = stringResource(id = R.string.tag_rpu),
                style = AkiraTheme.typography.body2.copy(
                    color = if (enable) colors.gray2 else colors.gray5
                ),
                maxLines = 1,
            )
        }
        Spacer(modifier = Modifier.width(spacings.spacingXxs))
    }
}