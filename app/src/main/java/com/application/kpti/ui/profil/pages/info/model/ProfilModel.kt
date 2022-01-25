package com.application.kpti.ui.profil.model

import com.application.kpti.ui.detailproperty.model.Data
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfilInfoItem(
    val date: String,
    val decription: String,
    val img_info: String
)