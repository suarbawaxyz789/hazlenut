package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.postcodesequencing.components

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.bespoke.ProgressBar
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostcodeSequenceAppBarUiState
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.AppBarHeader

@Preview
@Composable
private fun PostcodeSequenceAppBarPreview() {
    PostcodeSequenceAppBar(
        uiState = PostcodeSequenceAppBarUiState(
            numOfSequencedPostcodes = 3,
            totalPostcodes = 80,
        )
    )
}

@Composable
fun PostcodeSequenceAppBar(
    uiState: PostcodeSequenceAppBarUiState,
) {
    /// system status bar should follow appbar color
    val context = LocalContext.current
    if (context is ComponentActivity) {
        context.window.statusBarColor = colors.gray8.toArgb()
        WindowCompat.getInsetsController(context.window, context.window.decorView).apply {
            isAppearanceLightStatusBars = true
        }
    }

    Box(modifier = Modifier.background(color = colors.gray8)) {
        Column(
            modifier = Modifier
                .padding(horizontal = spacings.spacingS)
        ) {
            Spacer(modifier = Modifier.height(spacings.spacingXxs))
            AppBarHeader(
                title = stringResource(id = R.string.route_title),
                subtitleContent = {
                    Row {
                        Text(
                            text = stringResource(
                                id = R.string.postcodes_sequenced,
                                uiState.numOfSequencedPostcodes,
                                uiState.totalPostcodes
                            ),
                            style = typography.body2.copy(
                                color = colors.gray2
                            ),
                        )
                        Spacer(modifier = Modifier.width(spacings.spacingXxs))
                        Icon(
                            painter = painterResource(id = R.drawable.icon_l_question_circle_filled),
                            contentDescription = null, modifier = Modifier.size(spacings.spacingM)
                        )
                    }
                },
            )
            Spacer(modifier = Modifier.height(spacings.spacingXxs))
            ProgressBar(
                progress = uiState.numOfSequencedPostcodes.toFloat() / uiState.totalPostcodes.toFloat(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(spacings.spacingS))
        }
    }
}
