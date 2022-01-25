package com.application.kpti.ui.detailproperty.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListDataProperty(
    val `data`: List<Data>
)

@JsonClass(generateAdapter = true)
data class Data(
    val id: String,
    val property_image: String
)