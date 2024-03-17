package com.example.hazelnut.ui.features.ninjas.driverapponly

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R

@Composable
fun IconByJobType(type: JobType, enable: Boolean = true) {
    var iconResourceId: Int?
    //// TODO continue this when we have assets.
    when (type) {
        JobType.DELIVERY -> iconResourceId = R.drawable.icon_l_th_flag
        JobType.RTS -> iconResourceId = R.drawable.icon_l_ph_flag
        JobType.RPU -> iconResourceId = R.drawable.icon_l_my_flag
        JobType.PICKUP -> iconResourceId = R.drawable.icon_l_ps_flag
    }

    Icon(
        painter = painterResource(id = iconResourceId),
        contentDescription = null,
        tint = Color.Unspecified,
        modifier = Modifier.size(AkiraTheme.spacings.spacingS, AkiraTheme.spacings.spacingS)
    )

}

enum class JobType {
    DELIVERY,
    RTS,
    RPU,
    PICKUP
}