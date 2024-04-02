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

    var tags = arrayListOf(
        JobLabelStyle.COD,
        JobLabelStyle.PRIOR,
        JobLabelStyle.DOOR_STEP,
        JobLabelStyle.ID_CHECK
    )

    Column {
        listOfSample.mapIndexed { index, pairs ->
            WaypointCard(
                waypointModel = WaypointModel(
                    address = "3 Changi South street 2, Singapore 837484",
                    jobListData = pairs,
                    name = "Butterfly shop",
                    enabled = false,
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

    var tags = arrayListOf(
        JobLabelStyle.COD,
        JobLabelStyle.PRIOR,
        JobLabelStyle.DOOR_STEP,
        JobLabelStyle.ID_CHECK
    )

    Column {
        listOfSample.mapIndexed { index, pairs ->
            WaypointCard(
                waypointModel = WaypointModel(
                    address = "3 Changi South street 2, Singapore 837484",
                    jobListData = pairs,
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

    var tags = arrayListOf(
        JobLabelStyle.COD,
        JobLabelStyle.PRIOR,
        JobLabelStyle.DOOR_STEP,
        JobLabelStyle.ID_CHECK
    )

    Column {
        listOfSample.mapIndexed { index, pairs ->
            WaypointCard(
                waypointModel = WaypointModel(
                    address = "3 Changi South street 2, Singapore 837484",
                    jobListData = pairs,
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
                                if (waypointModel.jobListData != null) {
                                    Row {
                                        waypointModel.jobListData.forEach { pair ->
                                            JobTypeLabel(
                                                type = pair.first,
                                                parcels = pair.second,
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
                                            text = stringResource(
                                                id = R.string.unscanned_parcles_count,
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
private fun JobTypeLabel(type: JobType, parcels: List<String>, enable: Boolean = true) {
    if (parcels.isEmpty()) return Row {}
    if (parcels.size == 1) {
        return Row(verticalAlignment = Alignment.CenterVertically) {
            IconByJobType(type = type, enable = enable)
            Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
            if (type == JobType.RTS) {
                Text(
                    text = stringResource(id = R.string.parcel_rts),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )
            }
            if (type == JobType.RPU) {
                Text(
                    text = stringResource(id = R.string.parcel_rts),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )
            }
            Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
            Text(
                text = parcels.first(),
                style = AkiraTheme.typography.body2.copy(
                    color = if (enable) AkiraTheme.colors.gray3 else AkiraTheme.colors.gray5
                ),
                maxLines = 1,
            )
        }
    }

    return Row(verticalAlignment = Alignment.CenterVertically) {
        IconByJobType(type = type, enable = enable)
        Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
        Text(
            text = parcels.size.toString(),
            style = AkiraTheme.typography.body2.copy(
                color = if (enable) AkiraTheme.colors.gray1 else AkiraTheme.colors.gray5
            ),
            maxLines = 1,
        )
        Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
        if (type == JobType.RTS) {
            Text(
                text = stringResource(id = R.string.parcel_rts),
                style = AkiraTheme.typography.body2.copy(
                    color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                ),
                maxLines = 1,
            )
        }
        if (type == JobType.RPU) {
            Text(
                text = stringResource(id = R.string.text_rpu_tag),
                style = AkiraTheme.typography.body2.copy(
                    color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                ),
                maxLines = 1,
            )
        }
        Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
    }
}