package com.application.kpti.ui.home.Epoxy

data class HomeProperty(
    val img_user: String,
    val init_location: String,
    val property_populer: List<PropertyPopuler>,
    val property_sekitar: List<PropertySekitar>,
    val property_terkini: List<PropertyTerkini>
)

data class PropertyPopuler(
    val id : Long,
    val img_property: String,
    val property_name: String
)

data class PropertySekitar(
    val id : Long,
    val distance: String,
    val img_property: String,
    val property_name: String
)

data class PropertyTerkini(
    val id : Long,
    val img_property: String,
    val location: String,
    val price: String,
    val property_name: String
)