package com.application.kpti.ui.register.viewmodel

import androidx.lifecycle.ViewModel
import com.application.kpti.ui.login.viewmodel.LoginViewModel
import com.application.kpti.ui.register.model.RegisterModel
import com.application.kpti.ui.register.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel  @Inject constructor(val registerRepository: RegisterRepository) : ViewModel() {

    fun doRegister(registerModel: RegisterModel) : Flow<registerState> {
        if (registerModel.nama.isEmpty() ||
            registerModel.email.isEmpty() ||
            registerModel.nohp.isEmpty() ||
            registerModel.password.isEmpty() ||
            registerModel.confirmPassword.isEmpty()
        ) {
            return flow {
                emit(registerState.registerError("Lengkapi data pada form register"))
            }
        } else if (registerModel.password != registerModel.confirmPassword) {
            return flow {
                emit(registerState.registerErrorPasswords("Password tidak sama"))
            }
        }else {
            return flow {
                emit(registerState.registerSuccess("Registrasi Success"))
            }
        }
    }

    sealed class registerState {
        data class registerError(val message : String) : registerState()
        data class registerSuccess(val message : String) : registerState()
        data class registerErrorPasswords(val message : String) : registerState()
    }

}