package com.application.kpti.ui.detailproperty.model

data class ListDataProperty(
    val `data`: List<Data>
)

data class Data(
    val id: String,
    val property_image: String
)