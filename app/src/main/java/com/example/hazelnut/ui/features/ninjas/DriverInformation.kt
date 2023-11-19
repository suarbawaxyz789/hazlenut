package com.example.hazelnut.ui.features.ninjas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazelnut.R
import com.example.hazelnut.ui.theme.ninjas.TextView

@Preview
@Composable
fun TestPreview() {
    Row(
        modifier = Modifier
            .background(color = colorResource(id = R.color.white))
            .padding(vertical = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 12.dp)
        ) {
            BottomSheetHeader()
            DriverInformation(modifier = Modifier.padding(top = 10.dp, bottom = 30.dp))
            EarningPerParcelInstruction()
        }
    }
}

@Composable
fun DisplayImage(imageResId: Int) {
    val painter: Painter = painterResource(id = imageResId)

    Image(
        painter = painter,
        contentDescription = null, // Provide a description for accessibility
        modifier = Modifier.wrapContentWidth(),
        contentScale = ContentScale.Fit // Adjust this based on how you want the image to fit
    )
}

@Composable
fun BottomSheetHeader(
    title: String? = null,
) {
    Row(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DisplayImage(
            R.drawable.icon_m_times
        )
        title?.let {
            TextView.Bold(
                text = title,
                textAlign = TextAlign.End,
                fontSize = 18.sp,
            )
        }
    }
}

@Composable
fun DriverInformation(
    driverName: String = "Driver name",
    region: String = "Greater Jakarata A",
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .wrapContentWidth()
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DisplayImage(
            R.drawable.driver_information,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 12.dp)
        ) {
            TextView.Bold(
                text = driverName,
                textAlign = TextAlign.End,
                fontSize = 18.sp,
            )
            TextView.Regular(
                text = region, textAlign = TextAlign.End, fontSize = 16.sp
            )
        }
    }
}

@Composable
fun EarningPerParcelInstruction() {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextView.Bold(
                text = "Earning per parcel",
                textAlign = TextAlign.End,
                fontSize = 18.sp,
            )
            TextView.Regular(
                text = "The amount you'll receive for delivering a parcel depends on the size of the parcel.\n" + "1. Marketplace: Lazada, Tiktok, Shopee, Tokopedia, Bukalapak, Blibli\n" + "2. Non-MP: Soscom, KPP, BPJS, Bank, Mitra",
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                color = R.color.gray8f,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}