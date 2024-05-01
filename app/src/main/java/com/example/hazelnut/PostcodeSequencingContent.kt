package com.example.hazelnut

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.component.button.BaseSecondaryButton
import co.ninjavan.akira.designsystem.component.button.ButtonTextLink
import co.ninjavan.akira.designsystem.component.button.PrimaryLabelGrayButton
import co.ninjavan.akira.designsystem.component.button.SecondaryLabelGrayButton
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostalCodeSequencingActivityUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.postcodesequencing.AddPostcodeButton
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.postcodesequencing.WaypointToAddLocation
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components.PostcodeSequenceAppBar
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel.PostcodeSequencingViewModel
import ninjavan.swiftninja.mvvm.ui.groupbypostcode.base.PostcodeCard
import ninjavan.swiftninja.mvvm.ui.groupbypostcode.event.PostcodeSequencingEvent

@Preview
@Composable
private fun PostcodeSequenceContentPreview() {
    val viewModel = PostcodeSequencingViewModel()
    viewModel.onUserAction(PostcodeSequencingEvent.UserAction.SetRouteId(123))
    viewModel.testData()
    Content(viewModel = viewModel)
}

@Composable
private fun Content(viewModel: PostcodeSequencingViewModel) {
    val uiState: PostalCodeSequencingActivityUiState = viewModel.uiState.collectAsState().value
    AkiraTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Scaffold(
                    floatingActionButton = {
                        PageFloatingButton(
                            onShowFilterButtonClick = {
                                /// TODO open filter.
                            },
                            uiState = uiState,
                        )
                    },
                    topBar = {
                        PostcodeSequenceAppBar(
                            uiState = uiState.appBarUiState
                        )
                    },
                    bottomBar = {
                        MainButton(uiState = uiState)
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(innerPadding)
                    ) {
                        SelectAllPostcodeButton(
                            totalPostcodes = uiState.sequencedPostcodesUiState.size,
                            numOfSelectedPostcode = uiState.numOfSelectedPostcodes,
                            onSelectAll = {
                                viewModel.onUserAction(PostcodeSequencingEvent.UserAction.SelectAllPostcodes)
                            },
                            onClear = {
                                viewModel.onUserAction(PostcodeSequencingEvent.UserAction.ClearPostcodeSelection)
                            })
                        AddPostcodeButton(
                            location = WaypointToAddLocation.TOP,
                            postcodeSearchUiState = uiState.unsequencedPostcodesSearch
                        )
                        uiState.sequencedPostcodesUiState.map { postcodeState ->
                            PostcodeCard(
                                cardUiState = postcodeState,
                                postcodeSearchUiState = uiState.unsequencedPostcodesSearch,
                                onClick = {
                                    viewModel.onUserAction(
                                        PostcodeSequencingEvent.UserAction.OnPostcodeCardTap(
                                            postcodeState
                                        )
                                    );
                                },
                                numOfSelectedPostcode = uiState.numOfSelectedPostcodes,
                                allowToShowAddPostcodeButton = postcodeState.postcode != uiState.sequencedPostcodesUiState.last().postcode
                            )
                        }
                        AddPostcodeButton(
                            location = WaypointToAddLocation.BOTTOM,
                            postcodeSearchUiState = uiState.unsequencedPostcodesSearch
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MainButton(uiState: PostalCodeSequencingActivityUiState) {
    Row(
        modifier = Modifier
            .padding(all = spacings.spacingS)
            .fillMaxWidth()
    ) {
        when {
            uiState.numOfSelectedPostcodes > 0 -> {
                SecondaryLabelRedButton(
                    text = "Remove ${uiState.numOfSelectedPostcodes} postcode",
                    onClick = {
                        // TODO save sequence
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            uiState.sequencedPostcodesUiState.isEmpty() || uiState.unsequencedPostcodesUiState.isNotEmpty() -> {
                SecondaryLabelGrayButton(text = "Save sequence", onClick = {
                    // TODO save sequence
                }, modifier = Modifier.fillMaxWidth())
            }

            uiState.sequencedPostcodesUiState.isNotEmpty() && uiState.unsequencedPostcodesUiState.isEmpty() -> {
                PrimaryLabelGrayButton(text = "Confirm sequence", onClick = {
                    // TODO save sequence
                }, modifier = Modifier.fillMaxWidth())
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
        containerColor = AkiraTheme.colors.white,
        pressedContainerColor = AkiraTheme.colors.gray8,
        contentColor = AkiraTheme.colors.red3,
        isLoading = isLoading,
        iconResId = iconResId,
        borderStroke = BorderStroke(1.dp, AkiraTheme.colors.red3)
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
            ButtonTextLink(text = "Select all (${totalPostcodes})",
                onClick = { onSelectAll?.invoke() })
            Spacer(modifier = Modifier.weight(1f))
            if (numOfSelectedPostcode > 0) {
                ButtonTextLink(text = "Clear", onClick = { onClear?.invoke() })
            }
        }
        androidx.compose.material3.Divider(
            color = AkiraTheme.colors.gray7,
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
            backgroundColor = AkiraTheme.colors.gray2, onClick = {
                onShowFilterButtonClick?.invoke()
            }, shape = CircleShape, modifier = Modifier.size(50.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_l_action),
                contentDescription = null,
                tint = AkiraTheme.colors.white
            )
        }
    }
}