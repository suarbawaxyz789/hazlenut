package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.component.checkbox.Checkbox
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.akira.button.ButtonTextLink
import com.example.hazelnut.ui.features.ninjas.akira.button.PrimaryLabelGrayButton
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobTag
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.WaypointFilterUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.BottomSheetHeader

@Preview
@Composable
private fun WaypointFilterActionPreview() {
    var uiState = remember {
        mutableStateOf(
            WaypointFilterUiState(
                selectedTags = arrayListOf(),
                selectedJobTypes = arrayListOf(),
            )
        )
    }
    WaypointsFilterOption(uiState)
}

@Composable
fun WaypointsFilterOption(
    uiState: MutableState<WaypointFilterUiState>,
    onApply: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .background(
                color = colors.white
            )
            .padding(
                end = spacings.spacingS,
                top = spacings.spacingL,

                )
    ) {
        Content(
            uiState = uiState,
        )
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier.padding(
                start = spacings.spacingS
            )
        ) {
            Footer(onApply = onApply, onClearAll = {
                uiState.value = uiState.value.copy(
                    selectedJobTypes = arrayListOf(),
                    selectedTags = arrayListOf()
                )
            })
        }
    }
}

@Composable
private fun Content(
    uiState: MutableState<WaypointFilterUiState>,
) {
    Column {
        Text(
            text = stringResource(id = R.string.filter_by_job),
            style = typography.body1Bold.copy(
                color = colors.gray2
            ),
            modifier = Modifier.padding(start = spacings.spacingS)
        )
        JobTypeFilterCheckbox(
            jobType = JobType.DELIVERY,
            uiState = uiState,
        )
        JobTypeFilterCheckbox(
            jobType = JobType.PICKUP,
            uiState = uiState,
        )
        JobTypeFilterCheckbox(
            jobType = JobType.RPU,
            uiState = uiState,
        )
        JobTypeFilterCheckbox(
            jobType = JobType.RTS,
            uiState = uiState,
        )

        Spacer(modifier = Modifier.height(spacings.spacingS))
        Text(
            text = stringResource(id = R.string.filter_by_tag),
            style = typography.body1Bold.copy(
                color = colors.gray2
            ),
            modifier = Modifier.padding(start = spacings.spacingS)
        )

        TagFilterCheckbox(
            jobTag = JobTag.PRIOR,
            uiState = uiState,
        )
        TagFilterCheckbox(
            jobTag = JobTag.COD,
            uiState = uiState,
        )
        TagFilterCheckbox(
            jobTag = JobTag.DOORSTEP,
            uiState = uiState,
        )
        TagFilterCheckbox(
            jobTag = JobTag.ID_CHECK,
            uiState = uiState,
        )
    }
}

@Composable
private fun JobTypeFilterCheckbox(
    jobType: JobType,
    uiState: MutableState<WaypointFilterUiState>,
) {
    val currentToggleState =
        if (uiState.value.selectedJobTypes.contains(jobType)) ToggleableState.On else ToggleableState.Off

    val labelStringId = when (jobType) {
        JobType.DELIVERY -> R.string.filter_job_delivery
        JobType.RTS -> R.string.filter_job_pickup
        JobType.RPU -> R.string.filter_job_rpu
        JobType.PICKUP -> R.string.filter_job_rts
    }
    Checkbox(
        modifier = Modifier.padding(start = spacings.spacingXxxs),
        toggleableState = currentToggleState,
        label = stringResource(id = labelStringId),
        onCheckedChange = { toggleableState ->
            if (toggleableState == ToggleableState.On) {
                uiState.value = uiState.value.copy(
                    selectedJobTypes = uiState.value.selectedJobTypes + jobType,
                )
            } else {
                uiState.value = uiState.value.copy(
                    selectedJobTypes = uiState.value.selectedJobTypes - jobType,
                )
            }
        }
    )
}

@Composable
private fun TagFilterCheckbox(
    jobTag: JobTag,
    uiState: MutableState<WaypointFilterUiState>,
) {
    val currentToggleState =
        if (uiState.value.selectedTags.contains(jobTag)) ToggleableState.On else ToggleableState.Off

    val labelStringId = when (jobTag) {
        JobTag.PRIOR -> R.string.filter_tag_prior
        JobTag.COD -> R.string.filter_tag_cod
        JobTag.DOORSTEP -> R.string.filter_tag_doorstep
        JobTag.ID_CHECK -> R.string.filter_tag_id_check
    }

    Checkbox(
        modifier = Modifier.padding(start = spacings.spacingXxxs),
        toggleableState = currentToggleState,
        label = stringResource(id = labelStringId),
        onCheckedChange = { toggleableState ->
            if (toggleableState == ToggleableState.On) {
                uiState.value = uiState.value.copy(
                    selectedTags = uiState.value.selectedTags + jobTag,
                )
            } else {
                uiState.value = uiState.value.copy(
                    selectedTags = uiState.value.selectedTags - jobTag,
                )
            }
        }
    )
}

@Composable
private fun Footer(
    onApply: (() -> Unit)?,
    onClearAll: (() -> Unit)?,
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ButtonTextLink(text = stringResource(id = R.string.clear_all), onClick = {
                onClearAll?.invoke()
            })
            Spacer(modifier = Modifier.weight(1f))
            PrimaryLabelGrayButton(
                text = stringResource(id = R.string.apply_filter),
                onClick = {
                    onApply?.invoke()
                },
            )
        }
        Spacer(modifier = Modifier.height(spacings.spacingS))
    }
}