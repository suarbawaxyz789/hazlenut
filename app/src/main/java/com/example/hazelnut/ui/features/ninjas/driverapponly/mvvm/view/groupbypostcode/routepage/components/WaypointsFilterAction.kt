package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.JobTag
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.WaypointFilterUiState

@Preview
@Composable
private fun WaypointFilterActionPreview() {
    var uiState = WaypointFilterUiState(
        selectedTags = arrayListOf(),
        selectedJobTypes = arrayListOf(),
    )
    WaypointsFilterAction(uiState)
}

@Composable
fun WaypointsFilterAction(
    uiState: WaypointFilterUiState,
    onJobTypeFilterChange: ((ToggleableState, JobType) -> Unit)? = null,
    onTagFilterChange: ((ToggleableState, JobTag) -> Unit)? = null,
    onClose: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier
            .background(
                color = colors.white
            )
            .padding(
                start = spacings.spacingS,
                end = spacings.spacingS,
                top = spacings.spacingL
            )
    ) {
        Header(onClose = onClose)
        Spacer(modifier = Modifier.height(spacings.spacingL))
        Content(
            uiState = uiState,
            onTagFilterChange = onTagFilterChange,
            onJobTypeFilterChange = onJobTypeFilterChange,
        )
    }
}

@Composable
private fun Content(
    uiState: WaypointFilterUiState,
    onJobTypeFilterChange: ((ToggleableState, JobType) -> Unit)? = null,
    onTagFilterChange: ((ToggleableState, JobTag) -> Unit)? = null,
) {
    Column {
        Text(
            text = stringResource(id = R.string.filter_by_job),
            style = typography.body1Bold.copy(
                color = colors.gray2
            ),
        )
        JobTypeFilterCheckbox(
            jobType = JobType.DELIVERY,
            uiState = uiState,
            onJobTypeFilterChange = onJobTypeFilterChange
        )
        JobTypeFilterCheckbox(
            jobType = JobType.PICKUP,
            uiState = uiState,
            onJobTypeFilterChange = onJobTypeFilterChange
        )
        JobTypeFilterCheckbox(
            jobType = JobType.RPU,
            uiState = uiState,
            onJobTypeFilterChange = onJobTypeFilterChange
        )
        JobTypeFilterCheckbox(
            jobType = JobType.RTS,
            uiState = uiState,
            onJobTypeFilterChange = onJobTypeFilterChange
        )

        Spacer(modifier = Modifier.height(spacings.spacingS))
        Text(
            text = stringResource(id = R.string.filter_by_tag),
            style = typography.body1Bold.copy(
                color = colors.gray2
            ),
        )

        TagFilterCheckbox(
            jobTag = JobTag.PRIOR,
            uiState = uiState,
            onJobTypeFilterChange = onTagFilterChange
        )
        TagFilterCheckbox(
            jobTag = JobTag.COD,
            uiState = uiState,
            onJobTypeFilterChange = onTagFilterChange
        )
        TagFilterCheckbox(
            jobTag = JobTag.DOORSTEP,
            uiState = uiState,
            onJobTypeFilterChange = onTagFilterChange
        )
        TagFilterCheckbox(
            jobTag = JobTag.ID_CHECK,
            uiState = uiState,
            onJobTypeFilterChange = onTagFilterChange
        )

        Spacer(modifier = Modifier.weight(1f))
        Footer()

    }
}

@Composable
private fun JobTypeFilterCheckbox(
    jobType: JobType,
    uiState: WaypointFilterUiState,
    onJobTypeFilterChange: ((ToggleableState, JobType) -> Unit)? = null
) {
    val currentToggleState =
        if (uiState.selectedJobTypes.contains(jobType)) ToggleableState.Off else ToggleableState.Off

    val labelStringId = when (jobType) {
        JobType.DELIVERY -> R.string.filter_job_delivery
        JobType.RTS -> R.string.filter_job_pickup
        JobType.RPU -> R.string.filter_job_rpu
        JobType.PICKUP -> R.string.filter_job_rts
    }
    Checkbox(
        label = stringResource(id = labelStringId),
        defaultState = currentToggleState,
        onCheckedChange = { toggleableState ->
            onJobTypeFilterChange?.invoke(toggleableState, jobType)
        })
}

@Composable
private fun TagFilterCheckbox(
    jobTag: JobTag,
    uiState: WaypointFilterUiState,
    onJobTypeFilterChange: ((ToggleableState, JobTag) -> Unit)? = null
) {
    val currentToggleState =
        if (uiState.selectedTags.contains(jobTag)) ToggleableState.Off else ToggleableState.Off

    val labelStringId = when (jobTag) {
        JobTag.PRIOR -> R.string.filter_tag_prior
        JobTag.COD -> R.string.filter_tag_cod
        JobTag.DOORSTEP -> R.string.filter_tag_doorstep
        JobTag.ID_CHECK -> R.string.filter_tag_id_check
    }

    Checkbox(
        label = stringResource(id = labelStringId),
        defaultState = currentToggleState,
        onCheckedChange = { toggleableState ->
            onJobTypeFilterChange?.invoke(toggleableState, jobTag)
        })
}

@Composable
private fun Footer() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ButtonTextLink(text = stringResource(id = R.string.clear_all), onClick = {
                // TODO clear all selection
            })
            Spacer(modifier = Modifier.weight(1f))
            PrimaryLabelGrayButton(
                text = stringResource(id = R.string.apply_filter),
                onClick = { },
            )
        }
        Spacer(modifier = Modifier.height(spacings.spacingS))
    }
}


@Composable
private fun Header(
    onClose: (() -> Unit)?,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(id = R.string.filter_by),
            style = typography.heading6Bold.copy(
                color = colors.gray2
            ),
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = {
            onClose?.invoke()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.icon_l_times),
                contentDescription = null,
                modifier = Modifier.size(spacings.spacingS)
            )
        }
    }
}