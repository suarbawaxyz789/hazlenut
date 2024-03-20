package ninjavan.swiftninja.mvvm.ui.groupbypostcode.routepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.ui.features.ninjas.driverapponly.groupbypostcode.routepage.components.RoutePageAppBar
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

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
                CollapsingToolbarScaffold(
                    state = rememberCollapsingToolbarScaffoldState(),
                    scrollStrategy = ScrollStrategy.EnterAlways,
                    modifier = Modifier
                        .fillMaxSize(),
                    toolbar = {
                        RoutePageAppBar(viewModel = viewModel)
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = "Test",
                            style = typography.body2,
                        )
                    }
                }
            }
        }
    }
}