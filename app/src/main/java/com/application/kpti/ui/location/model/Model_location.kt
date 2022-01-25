package com.application.kpti.ui.location.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Filter_Location(
    val choose_state: List<ChooseState>,
    val recently: List<Recently>
)

@JsonClass(generateAdapter = true)
data class ChooseState(
    val location_name: String
)

@JsonClass(generateAdapter = true)
data class Recently(
    val location_name: String
)