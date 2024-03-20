package ninjavan.swiftninja.mvvm.ui.groupbypostcode.routepage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hazelnut.ui.features.ninjas.bespoke.BarValue
import com.example.hazelnut.ui.features.ninjas.bespoke.ProgressType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class RouteViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<RouteState>(RouteState.Nothing)
    val uiState = _uiState.asStateFlow()

    private val _routeId = mutableStateOf("")
    val routeId: State<String> = _routeId

    private val _barValues = mutableStateOf(arrayListOf<BarValue>())

    val barValues: State<List<BarValue>> = _barValues

    fun testData() {
        _routeId.value = "12346"
        _barValues.value = arrayListOf(
            BarValue(
                ProgressType.SUCCESS,
                progress = 0.1f,
                "15 successful waypoints",
            ),
            BarValue(
                ProgressType.PENDING,
                progress = 0.1f, "54 pending waypoints",
            ),
            BarValue(
                ProgressType.PARTIAL,
                progress = 0.1f, "1 partial waypoints",
            ),
            BarValue(
                ProgressType.FAILED,
                progress = 0.2f, "1 partial waypoints",
            ),
            BarValue(
                ProgressType.NONE,
                progress = 0.3f, "62 waypoints total",
            ),
        )
    }

}