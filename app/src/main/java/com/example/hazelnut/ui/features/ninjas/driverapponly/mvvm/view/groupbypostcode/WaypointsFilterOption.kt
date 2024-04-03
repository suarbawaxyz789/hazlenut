package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode

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
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.component.checkbox.Checkbox
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.akira.button.ButtonTextLink
import com.example.hazelnut.ui.features.ninjas.akira.button.PrimaryLabelGrayButton

@Preview
@Composable
private fun WaypointFilterOptionPreview() {
    WaypointsFilterOption()
}

@Composable
fun WaypointsFilterOption() {
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
        Header()
        Content()
    }
}

@Composable
private fun Content() {
//    Column {
//        Text(
//            text = stringResource(id = R.string.filter_by_job),
//            style = typography.body1Bold.copy(
//                color = colors.gray2
//            ),
//        )
//        Checkbox(label = stringResource(id = R.string.filter_job_delivery))
//        Checkbox(label = stringResource(id = R.string.filter_job_pickup))
//        Checkbox(label = stringResource(id = R.string.filter_job_rpu))
//        Checkbox(label = stringResource(id = R.string.filter_job_rts))
//
//        Spacer(modifier = Modifier.height(spacings.spacingS))
//        Text(
//            text = stringResource(id = R.string.filter_by_tag),
//            style = typography.body1Bold.copy(
//                color = colors.gray2
//            ),
//        )
//
//        Checkbox(label = stringResource(id = R.string.filter_tag_prior))
//        Checkbox(label = stringResource(id = R.string.filter_tag_cod))
//        Checkbox(label = stringResource(id = R.string.filter_tag_doorstep))
//        Checkbox(label = stringResource(id = R.string.filter_tag_id_check))
//
//        Spacer(modifier = Modifier.weight(1f))
//        Footer()
//
//    }
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
private fun Header() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(id = R.string.filter_by),
            style = typography.heading6Bold.copy(
                color = colors.gray2
            ),
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = {
            /// TODO close bottomsheet
        }) {
            Icon(
                painter = painterResource(id = R.drawable.icon_l_times),
                contentDescription = null,
                modifier = Modifier.size(spacings.spacingS)
            )
        }
    }
}