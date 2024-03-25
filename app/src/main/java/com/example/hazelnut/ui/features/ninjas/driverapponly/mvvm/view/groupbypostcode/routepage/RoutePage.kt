package ninjavan.swiftninja.mvvm.ui.groupbypostcode.routepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.ui.features.ninjas.driverapponly.WaypointsGroupByPostcode
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.routepage.components.RoutePageAppBar
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.viewmodel.RouteViewModel

@Preview
@Composable
private fun TestPreview() {
    var viewModel = RouteViewModel();
    viewModel.testData()
    RoutePageComponent(viewModel = viewModel)
}

@Composable
private fun RoutePageComponent(viewModel: RouteViewModel) {
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
                        Content(viewModel = viewModel)
                    }
                }
            }
        }
    }
}

@Composable
private fun Content(viewModel: RouteViewModel) {
    Column {
        viewModel.sequencedWaypointsGroupedByPostCode.value.map { waypointsGroup ->
            WaypointsGroupByPostcode(
                waypointsGroupModel = waypointsGroup,
            )
        }
    }
}