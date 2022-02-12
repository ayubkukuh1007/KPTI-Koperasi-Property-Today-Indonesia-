package com.application.kpti.ui.profil.pages.setting.viewmodel

import androidx.lifecycle.ViewModel
import com.application.kpti.ui.profil.pages.setting.model.SettingModel
import com.application.kpti.ui.profil.pages.setting.repository.RepositorySetting
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(val repository: RepositorySetting) : ViewModel() {

    fun getProfileSetting(){

    }

    fun editProfileSetting(settingModel: SettingModel) : Flow<profileEditSettingState>{
        val numberPhone = settingModel.phone.startsWith("0")
        val emailContainadd = settingModel.email.contains("@")
        if (settingModel.agent.isEmpty() ||
            settingModel.property.isEmpty() ||
            settingModel.email.isEmpty() ||
            settingModel.phone.isEmpty())
            {
                return flow {
                    emit(profileEditSettingState.settingError("Data Musti dilengkapi!"))
                }
            }else if (numberPhone) {
                return flow{
                    emit(profileEditSettingState.settingError("Number Phone Start with num 8 not 0"))
                }
            }else if (!emailContainadd){
                return flow{
                    emit(profileEditSettingState.settingError("Email Anda tidak valid add @"))
                }
            }else {
                return flow{
                    emit(profileEditSettingState.settingSuccess("Data Valid"))
                }
             }
    }

    sealed class profileEditSettingState {
        data class settingError(val message : String) : profileEditSettingState()
        data class settingSuccess(val message : String) : profileEditSettingState()
    }

}