package com.application.kpti.ui.location.model

data class Filter_Location(
    val choose_state: List<ChooseState>,
    val recently: List<Recently>
)

data class ChooseState(
    val location_name: String
)

data class Recently(
    val location_name: String
)