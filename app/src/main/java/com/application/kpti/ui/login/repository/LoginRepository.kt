package com.application.kpti.ui.login.repository

import com.application.kpti.Network.KptiService
import com.application.kpti.Preferences.Userdata
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val kptiService: KptiService) {
    //login
    suspend fun loginUser(userdata: Userdata) : Response<Userdata> = kptiService.Register()
}
