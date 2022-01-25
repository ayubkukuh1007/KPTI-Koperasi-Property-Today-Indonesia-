package com.application.kpti.ui.home.Epoxy

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeProperty(
    val img_user: String,
    val init_location: String,
    val property_populer: List<PropertyPopuler>,
    val property_sekitar: List<PropertySekitar>,
    val property_terkini: List<PropertyTerkini>
)
@JsonClass(generateAdapter = true)
data class PropertyPopuler(
    val id : Long,
    val img_property: String,
    val property_name: String,
    val isFavorite : Boolean
)
@JsonClass(generateAdapter = true)
data class PropertySekitar(
    val distance: String,
    val img_property: String,
    val property_name: String,
    val isFavorite: Boolean
)
@JsonClass(generateAdapter = true)
data class PropertyTerkini(
    val img_property: String,
    val location: String,
    val price: String,
    val property_name: String,
    val isFavorite: Boolean
)