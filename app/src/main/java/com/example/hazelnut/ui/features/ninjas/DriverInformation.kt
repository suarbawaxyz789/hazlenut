package com.example.hazelnut.ui.features.ninjas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazelnut.R
import com.example.hazelnut.ui.theme.ninjas.TextView

@Composable
fun DisplayImage(imageResId: Int) {
    val painter: Painter = painterResource(id = imageResId)

    Image(
        painter = painter,
        contentDescription = null, // Provide a description for accessibility
        modifier = Modifier
            .padding(16.dp),
        contentScale = ContentScale.Fit // Adjust this based on how you want the image to fit
    )
}

@Preview
@Composable
fun DriverInformation(
    driverName: String = "Driver name",
    region: String = "Driver Region",
){
    Row(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        DisplayImage(
            R.drawable.driver_information
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 12.dp)) {
            TextView.Regular(
                text = driverName,
                textAlign = TextAlign.End,
                fontSize = 16.sp
            )
            TextView.Regular(
                text = region,
                textAlign = TextAlign.End,
                fontSize = 16.sp
            )
        }
    }
}