package com.application.kpti.ui.profil.pages.setting.repository

import com.application.kpti.Network.KptiService
import com.application.kpti.ui.profil.pages.setting.model.SettingModel
import javax.inject.Inject


class RepositorySetting @Inject constructor(val kptiService: KptiService) {

    suspend fun setsetting(setting : SettingModel){

    }
}