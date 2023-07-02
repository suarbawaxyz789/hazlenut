package com.example.hazelnut.ui.features

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class AuthenticationViewModel : ViewModel() {
    private val _data = mutableStateOf(Authentication())

    fun data(): Authentication {
        return _data.value
    }
    fun requestOtp() {
        _data.value = _data.value.copy(isSendingOtpInProgress = true)

        runBlocking {
            delay(1000)
            _data.value = _data.value.copy(isSendingOtpInProgress = false)
        }
    }

    fun setCurrentPhoneNumber(phoneNumber: String) {
        _data.value = _data.value.copy(
            phoneNumber = phoneNumber,
        )

        /// TODO this just for testing state.
        /// TODO later find proper way to handle validation.
        if (phoneNumber.isNotEmpty()) {
            _data.value = _data.value.copy(
                isSentOtpButtonEnable = true
            )
        } else {
            _data.value = _data.value.copy(
                isSentOtpButtonEnable = false
            )
        }
    }
}


data class Authentication(
    val isSendingOtpInProgress: Boolean = false,
    val isSentOtpButtonEnable: Boolean = false,
    val phoneNumber: String = "",
) {

}
