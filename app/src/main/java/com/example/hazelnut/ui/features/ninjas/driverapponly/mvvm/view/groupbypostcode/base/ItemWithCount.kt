package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.IconByJobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.JobType

@Preview
@Composable
private fun ItemWithCountPreview() {
    ItemWithCount(2, JobType.PICKUP, true)
}

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