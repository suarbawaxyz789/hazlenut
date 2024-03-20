package com.example.hazelnut.ui.features.ninjas.driverapponly

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme

@Composable
fun ItemWithCount(numOfItem: Int, jobType: JobType, enable: Boolean = true) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        IconByJobType(jobType, enable)
        Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxxs))
        Text(
            text = numOfItem.toString(),
            style = AkiraTheme.typography.body2.copy(
                color = if (enable) AkiraTheme.colors.gray1 else AkiraTheme.colors.gray7
            ),
            maxLines = 1,
        )
        Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXs))
    }
}