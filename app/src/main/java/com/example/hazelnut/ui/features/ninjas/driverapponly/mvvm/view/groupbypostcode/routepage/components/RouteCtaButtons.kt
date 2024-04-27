package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.component.button.PrimaryLabelGrayButton
import co.ninjavan.akira.designsystem.component.button.SecondaryLabelGrayButton
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.CTAButton
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.RouteStatusesUiState

@Preview
@Composable
private fun RouteCtaButtonTypePreview() {
    Column(modifier = Modifier.padding(horizontal = spacings.spacingS)) {
        RouteCtaButton(
            ctaButtonUiState = RouteStatusesUiState(
                ctaButtons = mutableListOf(
                    CTAButton.START_ROUTE,
                    CTAButton.CONTINUE_SEQUENCING,
                )
            )
        )
    }
}

@Composable
fun RouteCtaButton(ctaButtonUiState: RouteStatusesUiState, onClick: ((CTAButton) -> Unit)? = null) {
    Column(
        modifier = Modifier.padding(
            horizontal = spacings.spacingXxs,
            vertical = spacings.spacingXxs,
        )
    ) {
        ctaButtonUiState.ctaButtons?.map {
            Box(modifier = Modifier.run {
                if (it != ctaButtonUiState.ctaButtons.last()) {
                    this.padding(bottom = spacings.spacingXxs)
                } else {
                    this
                }
            }) {
                CtaButton(
                    uiState = it,
                    isUsingPrimaryButton = it == ctaButtonUiState.ctaButtons.first(),
                    onClick = {
                        onClick?.invoke(it)
                    })
            }
        }
    }
}

@Composable
private fun CtaButton(uiState: CTAButton, onClick: (() -> Unit)?, isUsingPrimaryButton: Boolean) {
    val buttonText = when (uiState) {
        CTAButton.SCAN_UNSCANNED_PARCELS -> stringResource(id = R.string.scan_unscanned_parcels)
        CTAButton.CONTINUE_SEQUENCING -> stringResource(id = R.string.cta_continue_sequencing)
        CTAButton.UPDATE_SEQUENCE -> stringResource(id = R.string.cta_update_sequence)
        CTAButton.START_SEQUENCING -> stringResource(id = R.string.cta_start_sequencing)
        CTAButton.CHANGE_SEQUENCE -> stringResource(id = R.string.cta_change_sequence)
        CTAButton.START_SCANNING -> stringResource(id = R.string.cta_start_scanning)
        CTAButton.START_ROUTE -> stringResource(id = R.string.start_route_text)
        CTAButton.SCAN_PARCELS -> stringResource(id = R.string.text_scan_parcels)
    }
    return if (isUsingPrimaryButton) {
        PrimaryLabelGrayButton(
            text = buttonText,
            onClick = {
                onClick?.invoke()
            },
            modifier = Modifier.fillMaxWidth()
        )
    } else {
        SecondaryLabelGrayButton(
            modifier = Modifier.fillMaxWidth(),
            text = buttonText,
            onClick = {
                onClick?.invoke()
            },
        )
    }
}
