package com.application.kpti.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.application.kpti.R
import com.application.kpti.databinding.LoginFragmentBinding
import com.application.kpti.helper.isOnline
import com.application.kpti.ui.login.model.LoginModel
import com.application.kpti.ui.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    val viewModel: LoginViewModel by hiltNavGraphViewModels(R.id.loginFragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.forgotPassword.setOnClickListener {
            //forgot password
        }

        binding.btnLogin.setOnClickListener {
            binding.loginProgressbar.visibility = View.VISIBLE
            lifecycleScope.launch {
                delay(1000)
                withContext(Dispatchers.Main){
                    binding.loginProgressbar.visibility = View.INVISIBLE
                    findNavController().navigate(R.id.action_loginFragment_to_navigation_home)
                }
            }
            /*val gmail = binding.gmail.editText?.text.toString()
            val password = binding.password.editText?.text.toString()
            val loginModel = LoginModel(gmail,password)
            lifecycleScope.launch {
                viewModel.doLogin(loginModel).collectLatest {
                    when(it){
                        is LoginViewModel.loginState.LoginSuccess -> {
                           //call Rest Api
                            if (isOnline(requireContext())){
                                findNavController().navigate(R.id.action_loginFragment_to_navigation_home)
                            }else {
                                context?.toast("Offline")
                            }
                        }

                        is LoginViewModel.loginState.LoginError -> {
                            context?.toast(it.message)
                        }
                    }
                }
            }*/
        }

        return view
    }


}