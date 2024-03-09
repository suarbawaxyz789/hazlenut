package com.example.hazelnut.ui.features.nijaswaypointdetail.components

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hazelnut.R
import com.example.hazelnut.ui.theme.ninjas.TextView

@VisibleForTesting
@Preview
@Composable
fun WpCardSample() {
    Column {
        WpCard(
            trackingId = "NVSGCTTDR000000999",
            timeSlot = "9 AM - 12 PM",
            address = "15 Changi South Street 2, #03-02, Singapore 123456",
            recipient = "Jessica Tan",
        )
        WpCard(
            trackingId = "NVSGCTTDR000000999",
            timeSlot = "9 AM - 12 PM",
            address = "15 Changi South Street 2, #03-02, Singapore 123456",
            recipient = "Jessica Tan",
            seqNo = "1",
            isShowRpu = false,
            isShowDelivery = false,
            isShowPrior = true,
        )
        WpCard(
            trackingId = "NVSGCTTDR000000999",
            timeSlot = "9 AM - 12 PM",
            address = "15 Changi South Street 2, #03-02, Singapore 123456",
            recipient = "Jessica Tan",
            seqNo = "2",
            isShowRpu = true,
            isShowDelivery = false,
            isShowPrior = false,
        )
        WpCard(
            trackingId = "NVSGCTTDR000000999",
            timeSlot = "9 AM - 12 PM",
            address = "15 Changi South Street 2, #03-02, Singapore 123456",
            recipient = "Jessica Tan",
            seqNo = "999",
            isShowRpu = true,
            isShowDelivery = true,
            isShowPrior = true,
        )
    }
}


@Composable
fun WpCard(
    modifier: Modifier = Modifier,
    trackingId: String,
    timeSlot: String? = null,
    seqNo: String? = null,
    address: String? = null,
    recipient: String? = null,
    isShowRpu: Boolean = false,
    isShowDelivery: Boolean = false,
    isShowPrior: Boolean = false,
) {
    Column(modifier = Modifier.background(colorResource(id = R.color.white))) {
        Divider()
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(top = 20.dp, bottom = 10.dp)
        ) {
            seqNo?.let {
                Box(modifier = Modifier.width(33.dp)) {
                    TextView.Regular(
                        text = "$it.", modifier = Modifier
                            .padding(top = 0.dp, bottom = 2.dp)
                    )
                }
            }
            if (seqNo == null) {
                Spacer(modifier = Modifier.width(33.dp))
            }
            Column(
                modifier = modifier
            ) {
                timeSlot?.let {
                    TextView.Bold(
                        text = it, modifier = Modifier
                            .padding(top = 0.dp, bottom = 2.dp)
                    )
                }
                address?.let {
                    TextView.Regular(
                        text = it, modifier = Modifier
                            .padding(top = 0.dp, bottom = 2.dp)
                    )
                }
                recipient?.let {
                    TextView.Regular(
                        text = it, modifier = Modifier
                            .padding(top = 5.dp, bottom = 2.dp)
                    )
                }
                TextView.Regular(
                    text = trackingId, modifier = Modifier
                        .padding(top = 0.dp, bottom = 2.dp)
                )
                Row(modifier = Modifier.padding(top = 5.dp)) {
                    if (isShowDelivery) {
                        Box(modifier = Modifier.padding(end = 10.dp)) {
                            JobLabel(
                                tagStyle = JobLabelStyle.DELIVERY
                            )
                        }
                    }
                    if (isShowRpu) {
                        Box(modifier = Modifier.padding(end = 10.dp)) {
                            JobLabel(
                                tagStyle = JobLabelStyle.RPU
                            )
                        }
                    }
                    if (isShowPrior) {
                        Box(modifier = Modifier.padding(end = 10.dp)) {
                            JobLabel(
                                tagStyle = JobLabelStyle.PRIOR
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}