package ninjavan.swiftninja.mvvm.ui.groupbypostcode.event

import androidx.compose.material.ModalBottomSheetValue
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.CurrentWaypointByStatusFilter
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobTag
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType


sealed class RouteWaypointsPostalcodeEvent {
    sealed class UserAction : RouteWaypointsPostalcodeEvent() {
        data class SetRouteId(val routeId: Long) : UserAction()
        data class SetFilterOptionBottomSheetVisible(val value: ModalBottomSheetValue) :
            UserAction()

        data class SetFilterActionBottomSheetVisible(val value: ModalBottomSheetValue) :
            UserAction()

        data class SetSearchPageVisible(val visible: Boolean) : UserAction()
        data class SetSearchFilter(val filter: CurrentWaypointByStatusFilter) : UserAction()
        data class SetSearchQuery(val query: String) : UserAction()
        object ClearSearch : UserAction()

        data class UpdateFilter(
            val selectedJobTypes: List<JobType>? = null,
            val selectedTags: List<JobTag>? = null
        ) : UserAction()
    }

    sealed class LifecycleEvent : RouteWaypointsPostalcodeEvent() {
        object OnCreate : LifecycleEvent()
    }

}