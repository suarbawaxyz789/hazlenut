package ninjavan.swiftninja.mvvm.ui.groupbypostcode.base

import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabel
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostcodeCardUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.TidWithJobStatus
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.postcodesequencing.AddPostcodeButton
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.postcodesequencing.WaypointToAddLocation

@Preview
@Composable
fun PostcodeCardPreview() {
    Column(
        modifier = Modifier.background(
            colors.white
        )
    ) {
        PostcodeCard(
            cardUiState = PostcodeCardUiState(
                postcode = "8394839",
                address = "3 Changi South Street 2, Singapore",
                mapTIDByJobType = mapOf(
                    JobType.DELIVERY to mutableListOf(
                        TidWithJobStatus(
                            jobStatus = "PENDING", "NVSGCTTDR000000989",
                        )
                    ),
                    JobType.PICKUP to mutableListOf(
                        TidWithJobStatus(
                            jobStatus = "PENDING", "NVSGCTTDR000000888",
                        )
                    )
                ),
                enabled = true,
                jobTags = mutableListOf(JobLabelStyle.PRIOR),
                numOfBulky = 1,
                seqNumber = 1,
                selected = true,
                waypointIds = listOf(1, 2, 3)
            )
        )
        PostcodeCard(
            cardUiState = PostcodeCardUiState(
                postcode = "8394839",
                address = "3 Changi South Street 2, Singapore",
                mapTIDByJobType = mapOf(
                    JobType.DELIVERY to mutableListOf(
                        TidWithJobStatus(
                            jobStatus = "PENDING", "NVSGCTTDR000000989",
                        )
                    ),
                    JobType.PICKUP to mutableListOf(
                        TidWithJobStatus(
                            jobStatus = "PENDING", "NVSGCTTDR000000888",
                        )
                    )
                ),
                enabled = true,
                jobTags = mutableListOf(),
                numOfBulky = 1,
                seqNumber = 1,
                waypointIds = listOf(1, 2, 3)
            )
        )
        PostcodeCard(
            cardUiState = PostcodeCardUiState(
                postcode = "8394839",
                address = "3 Changi South Street 2, Singapore",
                mapTIDByJobType = mapOf(
                    JobType.DELIVERY to mutableListOf(
                        TidWithJobStatus(
                            jobStatus = "PENDING", "NVSGCTTDR000000989",
                        )
                    ),
                    JobType.PICKUP to mutableListOf(
                        TidWithJobStatus(
                            jobStatus = "PENDING", "NVSGCTTDR000000888",
                        )
                    )
                ),
                enabled = true,
                jobTags = mutableListOf(JobLabelStyle.PRIOR),
                numOfBulky = 0,
                seqNumber = 1,
                waypointIds = listOf(1, 2, 3)
            )
        )
    }
}

@Composable
fun PostcodeCard(
    cardUiState: PostcodeCardUiState,
    numOfSelectedPostcode: Int = 0,
    onClick: (() -> Unit)? = null,
) {
    Column {
        Column(modifier = (if (cardUiState.enabled) Modifier.clickable {
            onClick?.invoke()
        } else Modifier).run {
            if (cardUiState.selected) {
                this.background(colors.blue6)
            } else {
                this
            }
        }) {
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
                        if (cardUiState.numOfBulky > 0) {
                            Row(modifier = Modifier.padding(end = spacings.spacingXxs)) {
                                Text(
                                    text = "${cardUiState.numOfBulky} Bulky",
                                    style = typography.body2,
                                )
                            }
                        }
                        cardUiState.jobTags?.let { jobTagList ->
                            if (jobTagList.isEmpty()) {
                                Spacer(modifier = Modifier.width(spacings.spacingXxxl))
                            } else {
                                Row(modifier = Modifier.width(spacings.spacingXxxl)) {
                                    // postcode card only have PRIOR
                                    JobLabel(
                                        tagStyle = jobTagList.first(),
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
            Divider(
                color = colors.gray7,
            )
        }

        if (cardUiState.selected && numOfSelectedPostcode == 1) {
            AddPostcodeButton(location = WaypointToAddLocation.BELOW_SELECTED_WAYPOINT)
        }
    }
}