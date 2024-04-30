package ninjavan.swiftninja.mvvm.ui.groupbypostcode.event

import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.PostcodeCardUiState


sealed class PostcodeSequencingEvent {
    sealed class UserAction : PostcodeSequencingEvent() {
        data class SetRouteId(val routeId: Long) : UserAction()
        data class OnPostcodeCardTap(val postcodeUiState: PostcodeCardUiState) : UserAction()
        object ClearPostcodeSelection : UserAction()
        object SelectAllPostcodes : UserAction()
    }

    sealed class LifecycleEvent : PostcodeSequencingEvent() {
        object OnCreate : LifecycleEvent()
    }

}