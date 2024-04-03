package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models.JobType

@Composable
fun IconByJobType(type: JobType, enable: Boolean = true) {
    var iconResourceId: Int = if (enable) when (type) {
        JobType.DELIVERY -> R.drawable.icon_delivery
        JobType.RTS -> R.drawable.icon_rts
        JobType.RPU -> R.drawable.icon_rpu
        JobType.PICKUP -> R.drawable.icon_pickup
    } else R.drawable.icon_parcel_muted

    Icon(
        painter = painterResource(id = iconResourceId),
        contentDescription = null,
        tint = Color.Unspecified,
        modifier = Modifier
            .size(AkiraTheme.spacings.spacingM, AkiraTheme.spacings.spacingM)
            .rotate(if (!enable && (type == JobType.RTS || type == JobType.PICKUP)) 180F else 0F)
    )
}