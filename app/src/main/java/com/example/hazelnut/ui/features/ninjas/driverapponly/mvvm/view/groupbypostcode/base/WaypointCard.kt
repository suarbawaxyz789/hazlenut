package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
private fun WaypointCardPreview() {

    /// 1 job 1 parcel
    var sample1: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111"))
    )

    /// 1 job 2 parcel
    var sample2: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.DELIVERY, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
    )

    /// 2 job 2 parcel
    var sample3: List<Pair<JobType, List<String>>> = listOf(
        Pair(JobType.RTS, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112")),
        Pair(JobType.PICKUP, listOf("NVSGCTTDR000000111", "NVSGCTTDR000000112"))
    )

    Column {
        WaypointCard(
            waypointModel = WaypointModel(
                address = "3 Changi South street 2, Singapore 837484",
                jobListData = sample1,
                name = "Butterfly shop",
                enabled = true,
            ),
        )
        WaypointCard(
            waypointModel = WaypointModel(
                address = "3 Changi South street 2, Singapore 837484",
                jobListData = sample2,
                name = "Long name sfs fsf dsfa fas fdsafda sfdasfd asfdas sl;afjd asdfsfsdf sdfs dfsfdsdfs fsfsd ",
                enabled = true,
            )

        )
        WaypointCard(
            waypointModel = WaypointModel(
                address = "3 Changi South street 2, Singapore 837484",
                jobListData = sample3,
                name = "Buttefly shop",
                enabled = true,
            ),
        )
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
                        if (waypointModel.jobListData != null) {
                            Row(modifier = Modifier.weight(1f)) {
                                waypointModel.jobListData.forEach { pair ->
                                    JobTypeLabel(
                                        type = pair.first,
                                        parcels = pair.second
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(spacings.spacingXxs))

                    Row {
                        /// TODO better way to pass label from param.
                        JobLabel(
                            tagStyle = JobLabelStyle.PRIOR,
                            modifier = Modifier.padding(end = spacings.spacingXxxs),
                            enable = waypointModel.enabled,
                        )
                        JobLabel(
                            tagStyle = JobLabelStyle.COD,
                            modifier = Modifier.padding(end = spacings.spacingXxxs),
                            enable = waypointModel.enabled,
                        )
                    }
                }
            }
        }
        Divider(
            color = colors.gray7,
        )
    }
}

@Preview
@Composable
private fun JobTypeLabelPreview() {
    Column {
        JobTypeLabel(JobType.PICKUP, parcels = listOf("NVSGCTTDR000000294"))
        JobTypeLabel(
            JobType.PICKUP,
            parcels = listOf("NVSGCTTDR000000294", "NVSGCTTDR000000294")
        )
        JobTypeLabel(
            JobType.RPU,
            parcels = listOf("NVSGCTTDR000000294", "NVSGCTTDR000000294")
        )
        JobTypeLabel(
            JobType.RTS,
            parcels = listOf("NVSGCTTDR000000294", "NVSGCTTDR000000294")
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
            Text(
                text = parcels.first(),
                style = AkiraTheme.typography.body2.copy(
                    color = if (enable) colors.gray1 else colors.gray7
                ),
                maxLines = 1,
            )
            Spacer(modifier = Modifier.width(spacings.spacingXxs))
            if (type == JobType.RTS) {
                Text(
                    text = stringResource(id = R.string.parcel_rts),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) colors.gray1 else colors.gray7
                    ),
                    maxLines = 1,
                )
            }
            if (type == JobType.RPU) {
                Text(
                    text = stringResource(id = R.string.tag_rpu),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) colors.gray1 else colors.gray7
                    ),
                    maxLines = 1,
                )
            }
            Spacer(modifier = Modifier.width(spacings.spacingXxs))
        }
    }

    return Row(verticalAlignment = Alignment.CenterVertically) {
        IconByJobType(type = type, enable = enable)
        Spacer(modifier = Modifier.width(spacings.spacingXxs))
        Text(
            text = parcels.size.toString(),
            style = AkiraTheme.typography.body2.copy(
                color = if (enable) colors.gray1 else colors.gray7
            ),
            maxLines = 1,
        )
        Spacer(modifier = Modifier.width(spacings.spacingXxs))
        if (type == JobType.RTS) {
            Text(
                text = stringResource(id = R.string.parcel_rts),
                style = AkiraTheme.typography.body2.copy(
                    color = if (enable) colors.gray1 else colors.gray7
                ),
                maxLines = 1,
            )
        }
        if (type == JobType.RPU) {
            Text(
                text = stringResource(id = R.string.tag_rpu),
                style = AkiraTheme.typography.body2.copy(
                    color = if (enable) colors.gray1 else colors.gray7
                ),
                maxLines = 1,
            )
        }
        Spacer(modifier = Modifier.width(spacings.spacingXxs))
    }
}