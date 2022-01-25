package com.application.kpti.ui.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.kpti.ui.login.model.LoginModel
import com.application.kpti.ui.login.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(repository: LoginRepository) : ViewModel() {
//    private val _error = MutableLiveData<String>()
//    private val _success = MutableLiveData<String>()
//    val loginError : LiveData<String>
//        get() = _error
//    val loginSuccess : LiveData<String>
//        get() = _success

//        private val _res = MutableLiveData<Resource<EmployeeResponse>>()
//
//        val res : LiveData<Resource<EmployeeResponse>>
//            get() = _res
//
//        init {
//            getEmployees()
//        }
//
//        private fun getEmployees()  = viewModelScope.launch {
//            _res.postValue(Resource.loading(null))
//            mainRepository.getEmployee().let {
//                if (it.isSuccessful){
//                    _res.postValue(Resource.success(it.body()))
//                }else{
//                    _res.postValue(Resource.error(it.errorBody().toString(), null))
//                }
//            }
//        }


     fun doLogin(loginModel: LoginModel) : Flow<loginState> {
        if (loginModel.username.isEmpty() && loginModel.password.isNotEmpty()){
            return flow {
                emit(loginState.LoginError("Username Mohon di isi!"))
            }
        }else if (loginModel.password.isEmpty() && loginModel.username.isNotEmpty()){
            return flow {
                emit(loginState.LoginError("Password Mohon di isi!"))
            }
        }else if (loginModel.username.isEmpty() && loginModel.password.isEmpty()){
            return flow {
                emit(loginState.LoginError("Username dan Password Mohon diisi!"))
            }
        }else if (loginModel.username.isNotEmpty() && loginModel.password.isNotEmpty()){
            return flow {
                emit(loginState.LoginSuccess("Login Berhasil!"))
            }
        }else {
            return flow {
                emit(loginState.LoginError("Hubungi Admin"))
            }
        }

    }

    sealed class loginState {
        data class LoginError(val message : String) : loginState()
        data class LoginSuccess(val message : String) : loginState()
    }

}
