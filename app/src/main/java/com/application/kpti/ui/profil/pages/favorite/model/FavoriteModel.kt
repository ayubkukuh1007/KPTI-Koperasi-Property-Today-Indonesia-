package com.application.kpti.ui.profil.pages.favorite.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ListFavoriteItem(
    val favorite_property: String,
    val img_property: String,
    val price: String
)