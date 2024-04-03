package com.example.hazelnut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components.RoutePageAppBar
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components.WaypointsGroupByPostcode
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel.RouteWaypointsPostalcodeViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: RouteWaypointsPostalcodeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.testData()
        viewModel.setRouteId(123456)

        setContent {
            Content(viewModel = viewModel)
        }
    }
}

@Composable
private fun Content(viewModel: RouteWaypointsPostalcodeViewModel) {
    AkiraTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Scaffold(
                    topBar = {
                        RoutePageAppBar(viewModel = viewModel)
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(innerPadding)
                    ) {
                        viewModel.sequencedWaypointsGroupedByPostCode.value.map { waypointsGroup ->
                            WaypointsGroupByPostcode(
                                waypointsGroupModel = waypointsGroup,
                            )
                        }
                    }
                }
            }
        }
    }
}
