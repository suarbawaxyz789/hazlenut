package ninjavan.swiftninja.mvvm.ui.groupbypostcode.base

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabel
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostcodeCardUiState

@Preview
@Composable
fun PostcodeCardPreview() {
    Column {
        PostcodeCard(
            cardUiState = PostcodeCardUiState(
                postcode = "8394839",
                address = "3 Changi South Street 2, Singapore",
                mapTIDByJobType = mapOf(
                    JobType.DELIVERY to mutableListOf(
                        JobUiState(
                            jobStatus = "PENDING", "NVSGCTTDR000000989",
                        )
                    ),
                    JobType.PICKUP to mutableListOf(
                        JobUiState(
                            jobStatus = "PENDING", "NVSGCTTDR000000888",
                        )
                    )
                ),
                enabled = true,
                jobTags = mutableListOf(JobLabelStyle.PRIOR),
                numOfBulky = 1,
                seqNumber = 1,
            )
        )
        PostcodeCard(
            cardUiState = PostcodeCardUiState(
                postcode = "8394839",
                address = "3 Changi South Street 2, Singapore",
                mapTIDByJobType = mapOf(
                    JobType.DELIVERY to mutableListOf(
                        JobUiState(
                            jobStatus = "PENDING", "NVSGCTTDR000000989",
                        )
                    ),
                    JobType.PICKUP to mutableListOf(
                        JobUiState(
                            jobStatus = "PENDING", "NVSGCTTDR000000888",
                        )
                    )
                ),
                enabled = true,
                jobTags = mutableListOf(JobLabelStyle.PRIOR),
                numOfBulky = 1,
                seqNumber = 1,
            )
        )
    }
}

@Composable
fun PostcodeCard(
    cardUiState: PostcodeCardUiState,
    onClick: (() -> Unit)? = null,
) {
    Column(modifier = if (cardUiState.enabled) Modifier.clickable {
        onClick?.invoke()
    } else Modifier) {
        Row(
            modifier = Modifier
                .padding(all = spacings.spacingS)
        ) {
            Row(modifier = Modifier.width(spacings.spacingM)) {
                Text(
                    text = "${cardUiState.seqNumber}.",
                    style = typography.body2,
                )
            }
            Column {
                Text(
                    text = cardUiState.address,
                    style = typography.body2,
                )
                Spacer(modifier = Modifier.height(spacings.spacingXxs))
                Row {
                    Row(modifier = Modifier.weight(1f)) {
                        Column {
                            Row {
                                cardUiState.mapTIDByJobType.forEach { pair ->
                                    JobTypeLabel(
                                        type = pair.key,
                                        parcels = pair.value,
                                        isMultipleJobType = true,
                                        enable = cardUiState.enabled
                                    )
                                }
                            }
                        }
                    }
                    Row(modifier = Modifier.padding(end = spacings.spacingXxs)) {
                        Text(
                            text = "${cardUiState.numOfBulky} Bulky",
                            style = typography.body2,
                        )
                    }
                    cardUiState.jobTags?.let { jobTagList ->
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
                                    )
                                }
                            }
                            if (cardUiState.jobTags.size > 2) {
                                Row {
                                    jobTagList.slice(2 until jobTagList.size).map { jobTag ->
                                        JobLabel(
                                            tagStyle = jobTag,
                                            modifier = Modifier.padding(
                                                end = spacings.spacingXxxs,
                                                bottom = spacings.spacingXxxs
                                            ),
                                        )
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