package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.postcodesequencing

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.component.button.BaseSecondaryButton
import co.ninjavan.akira.designsystem.component.button.ButtonTextLink
import co.ninjavan.akira.designsystem.component.button.PrimaryLabelGrayButton
import co.ninjavan.akira.designsystem.component.button.SecondaryLabelGrayButton
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.akira_not_compatible.SearchBar
import com.example.hazelnut.ui.features.nijaswaypointdetail.components.JobLabelStyle
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostalCodeSequencingActivityUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostcodeCardUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostcodeSearchUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostcodeSequenceAppBarUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.TidWithJobStatus
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointToAddLocation
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.postcodesequencing.components.PostcodeSequenceAppBar
import ninjavan.swiftninja.mvvm.ui.groupbypostcode.base.PostcodeCard
import ninjavan.swiftninja.mvvm.ui.groupbypostcode.event.PostcodeSequencingEvent

@Preview
@Composable
private fun NormalContentPreview() {
    var uiState = PostalCodeSequencingActivityUiState(
        routeId = 394849,
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
        ),
        unsequencedPostcodesUiState = mutableListOf(
            PostcodeCardUiState(
                postcode = "999999",
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
                numOfBulky = 0,
                seqNumber = 3,
                waypointIds = listOf(10, 11, 12)
            )
        ),
        appBarUiState = PostcodeSequenceAppBarUiState(
            totalPostcodes = 4,
            numOfSequencedPostcodes = 3,
        )
    )
    PostalCodeSequencingContent(uiState = uiState)
}


@Preview
@Composable
private fun NoSequencedPostcodesPreview() {
    var uiState = PostalCodeSequencingActivityUiState(
        routeId = 394849,
        unsequencedPostcodesUiState = mutableListOf(
            PostcodeCardUiState(
                postcode = "999999",
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
                numOfBulky = 0,
                seqNumber = 3,
                waypointIds = listOf(10, 11, 12)
            )
        ),
        appBarUiState = PostcodeSequenceAppBarUiState(
            totalPostcodes = 4,
            numOfSequencedPostcodes = 3,
        )
    )
    PostalCodeSequencingContent(uiState = uiState)
}

@Preview
@Composable
private fun WithSearchPreview() {
    var uiState = PostalCodeSequencingActivityUiState(
        routeId = 394849,
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
        ),
        unsequencedPostcodesUiState = mutableListOf(
            PostcodeCardUiState(
                postcode = "999999",
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
                numOfBulky = 0,
                seqNumber = 3,
                waypointIds = listOf(10, 11, 12)
            )
        ),
        appBarUiState = PostcodeSequenceAppBarUiState(
            totalPostcodes = 4,
            numOfSequencedPostcodes = 3,
        ),
        unsequencedPostcodesSearch = PostcodeSearchUiState(
            isSearchPageActive = true,
        )
    )
    PostalCodeSequencingContent(uiState = uiState)
}

@Preview
@Composable
private fun AllSequencedPreview() {
    var uiState = PostalCodeSequencingActivityUiState(
        routeId = 394849,
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
        ),
        appBarUiState = PostcodeSequenceAppBarUiState(
            totalPostcodes = 3,
            numOfSequencedPostcodes = 3,
        )
    )
    PostalCodeSequencingContent(uiState = uiState)
}

@Composable
fun PostalCodeSequencingContent(
    uiState: PostalCodeSequencingActivityUiState,
    onUserAction: ((PostcodeSequencingEvent.UserAction) -> Unit)? = null,
) {
    AkiraTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Scaffold(floatingActionButton = {
                    PageFloatingButton(
                        onShowFilterButtonClick = {
                            /// TODO open filter.
                        },
                        uiState = uiState,
                    )
                }, topBar = {
                    PostcodeSequenceAppBar(
                        uiState = uiState.appBarUiState
                    )
                }, bottomBar = {
                    MainButton(uiState = uiState)
                }) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(innerPadding)
                    ) {
                        if (uiState.unsequencedPostcodesSearch.isSearchPageActive) {
                            Box(
                                modifier = Modifier
                                    .padding(
                                        horizontal = spacings.spacingS,
                                        vertical = spacings.spacingXxs
                                    )
                                    .background(
                                        colors.white
                                    )
                            ) {
                                SearchBar(
                                    onTextChange = {
                                        // TODO add action or searching
                                    },
                                    placeHolder = "",
                                )
                            }
                        }
                        if (uiState.sequencedPostcodesUiState.isNotEmpty() && uiState.unsequencedPostcodesUiState.isNotEmpty()) {
                            SelectAllPostcodeButton(totalPostcodes = uiState.sequencedPostcodesUiState.size,
                                numOfSelectedPostcode = uiState.numOfSelectedPostcodes,
                                onSelectAll = {
                                    onUserAction?.invoke(PostcodeSequencingEvent.UserAction.SelectAllPostcodes)
                                },
                                onClear = {
                                    onUserAction?.invoke(PostcodeSequencingEvent.UserAction.ClearPostcodeSelection)
                                })
                        }
                        AddPostcodeButton(
                            location = WaypointToAddLocation.TOP,
                            uiState = uiState,
                        )
                        // if no postcode sequenced, show only add waypoints (Middle)
                        if (uiState.sequencedPostcodesUiState.isEmpty()) {
                            AddPostcodeButton(
                                location = WaypointToAddLocation.ADD_FOR_THE_FIRST_TIME,
                                uiState = uiState,
                            )
                        }
                        uiState.sequencedPostcodesUiState.map { postcodeState ->
                            PostcodeCard(
                                cardUiState = postcodeState,
                                onClick = {
                                    onUserAction?.invoke(
                                        PostcodeSequencingEvent.UserAction.OnPostcodeCardTap(
                                            postcodeState
                                        )
                                    )
                                },
                                numOfSelectedPostcode = uiState.numOfSelectedPostcodes,
                                allowToShowAddPostcodeButton = postcodeState.postcode != uiState.sequencedPostcodesUiState.last().postcode,
                                isAllPostcodeSequenced = uiState.unsequencedPostcodesUiState.isEmpty()
                            )
                        }
                        AddPostcodeButton(
                            location = WaypointToAddLocation.BOTTOM,
                            uiState = uiState,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MainButton(uiState: PostalCodeSequencingActivityUiState) {
    val resources = LocalContext.current.resources

    Row(
        modifier = Modifier
            .padding(all = spacings.spacingS)
            .fillMaxWidth()
    ) {
        when {
            uiState.numOfSelectedPostcodes > 0 -> {
                SecondaryLabelRedButton(
                    /// tried pluralStringResource before but not working
                    text = resources.getQuantityString(
                        R.plurals.remove_n_postcodes,
                        uiState.numOfSelectedPostcodes,
                        uiState.numOfSelectedPostcodes,
                    ), onClick = {
                        // TODO save sequence
                    }, modifier = Modifier.fillMaxWidth()
                )
            }

            uiState.sequencedPostcodesUiState.isEmpty() || uiState.unsequencedPostcodesUiState.isNotEmpty() -> {
                SecondaryLabelGrayButton(
                    text = stringResource(id = R.string.cta_save_sequence), onClick = {
                        // TODO save sequence
                    }, modifier = Modifier.fillMaxWidth()
                )
            }

            uiState.sequencedPostcodesUiState.isNotEmpty() && uiState.unsequencedPostcodesUiState.isEmpty() -> {
                PrimaryLabelGrayButton(
                    text = stringResource(id = R.string.cta_confirm_sequence), onClick = {
                        // TODO save sequence and start route
                    }, modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

// TODO move this to akira later.
@Composable
fun SecondaryLabelRedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    iconResId: Int? = null
) {
    BaseSecondaryButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        containerColor = colors.white,
        pressedContainerColor = colors.gray8,
        contentColor = colors.red3,
        isLoading = isLoading,
        iconResId = iconResId,
        borderStroke = BorderStroke(1.dp, colors.red3)
    )
}

@Composable
private fun SelectAllPostcodeButton(
    numOfSelectedPostcode: Int = 0,
    totalPostcodes: Int = 0,
    onSelectAll: (() -> Unit)?,
    onClear: (() -> Unit)?,
) {
    Column {
        Row(
            modifier = Modifier.padding(
                horizontal = spacings.spacingS,
                vertical = spacings.spacingXxs,
            )
        ) {
            ButtonTextLink(text = stringResource(
                id = R.string.edit_sequence_select_all, totalPostcodes
            ), onClick = { onSelectAll?.invoke() })
            Spacer(modifier = Modifier.weight(1f))
            if (numOfSelectedPostcode > 0) {
                ButtonTextLink(text = stringResource(id = R.string.label_clear),
                    onClick = { onClear?.invoke() })
            }
        }
        Divider(
            color = colors.gray7,
        )
    }
}

@Composable
private fun PageFloatingButton(
    onShowFilterButtonClick: (() -> Unit)?,
    uiState: PostalCodeSequencingActivityUiState,
) {
    if (uiState.sequencedPostcodesUiState.isEmpty()) return
    Column {
        FloatingActionButton(
            backgroundColor = colors.gray2, onClick = {
                onShowFilterButtonClick?.invoke()
            }, shape = CircleShape, modifier = Modifier.size(50.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_l_action),
                contentDescription = null,
                tint = colors.white
            )
        }
    }
}