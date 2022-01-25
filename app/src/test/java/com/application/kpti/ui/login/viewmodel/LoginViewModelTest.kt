//package com.application.kpti.ui.login.viewmodel
//
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.application.kpti.Network.KptiService
//import com.application.kpti.Preferences.Userdata
//import com.application.kpti.ui.login.model.LoginModel
//import com.application.kpti.ui.login.repository.LoginRepository
//import org.junit.Test
//
//import org.junit.Assert.*
//import org.junit.Rule
//import org.junit.rules.TestRule
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.junit.MockitoJUnitRunner
//
//@RunWith(MockitoJUnitRunner::class)
//class LoginViewModelTest {
//
//    @get:Rule
//    var rule: TestRule = InstantTaskExecutorRule()
//
//    @Mock
//    lateinit var kptiService: KptiService
//
//    @Test
//    fun `test login`(){
//        val dataLogin = LoginModel("test","test")
//        val repo = LoginRepository(kptiService)
//        val loginViewmodel = LoginViewModel(repo)
//        loginViewmodel.doLogin(dataLogin)
//        assertEquals(loginViewmodel.error.value,"Login Berhasil!")
//    }
//
//
//}
