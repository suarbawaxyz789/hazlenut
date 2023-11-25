package com.example.hazelnut.ui.features.ninjas.views

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.items.entities.BonusCalculationMessageCardItem
import com.example.hazelnut.ui.theme.ninjas.TextView

@Composable
public fun BonusCardComponent(item: BonusCalculationMessageCardItem, context: Context) {
    Card(
        modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = colorResource(id = R.color.top_banner_bg),
        elevation = 0.dp
    ) {
        TextView.Italic(
            modifier = Modifier.padding(15.dp),
            text = context.getString(item.message),
            color = R.color.appealed_pill_bg_color
        )
    }
}
