package com.example.hazelnut.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazelnut.ui.widgets.AppButton
import com.togitech.ccp.component.TogiCountryCodePicker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(modifier: Modifier = Modifier) {
    val phoneNumber = rememberSaveable { mutableStateOf("") }
    val fullPhoneNumber = rememberSaveable { mutableStateOf("") }
    val onlyPhoneNumber = rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        Text(
            text = "Sign in to keep everything safe",
            style = MaterialTheme.typography.headlineSmall.copy(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(600),
            )
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "To access your account, please enter your phone number below :",
            style = MaterialTheme.typography.labelMedium.copy(
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        TogiCountryCodePicker(
            text = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            bottomStyle = false,
            shape = RoundedCornerShape(5.dp),
            color = MaterialTheme.colorScheme.background,
        )
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "Once you've entered your phone number, we will send you a verification code via SMS to confirm your identity. Please make sure the phone number you provide is correct.",
            style = MaterialTheme.typography.labelMedium.copy(
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        )
        Spacer(modifier = Modifier.padding(top = 40.dp))
        AppButton(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Text(text = "Send Otp", style = MaterialTheme.typography.labelMedium)
        }
    }
}