package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.models

import com.example.hazelnut.ui.features.ninjas.bespoke.ProgressType

class BarValueModel(color: ProgressType, progress: Float, legend: String) {
    var type: ProgressType = color
    var progress: Float = progress
    var legend: String = legend
}
