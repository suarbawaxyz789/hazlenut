package ninjavan.swiftninja.mvvm.ui.groupbypostcode.routepage

sealed class RouteState {
    object Nothing: RouteState()
    object Progress : RouteState()
    data class Error(val throwable: Throwable?) : RouteState()
    data class Success<out T>(val value: T) : RouteState()
}