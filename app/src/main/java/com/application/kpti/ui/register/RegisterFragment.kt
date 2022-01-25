package com.application.kpti.ui.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.application.kpti.R
import com.application.kpti.databinding.RegisterFragmentBinding
import com.application.kpti.helper.showmessage
import com.application.kpti.ui.register.model.RegisterModel
import com.application.kpti.ui.register.viewmodel.RegisterViewModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast

class RegisterFragment : Fragment() {

    private var _binding: RegisterFragmentBinding? = null
    private val binding get() = _binding!!

    val viewModel: RegisterViewModel by hiltNavGraphViewModels(R.id.registerFragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnSubmit.setOnClickListener {
            val nama = binding.nama.editText?.text.toString()
            val email = binding.Email.editText?.text.toString()
            val nohp = binding.nohp.editText?.text.toString()
            val password = binding.password.editText?.text.toString()
            val confirmPassword = binding.confirmPassword.editText?.text.toString()

            val registerModel = RegisterModel(
                nama = nama,
                email = email,
                nohp = nohp,
                password = password,
                confirmPassword = confirmPassword
            )

            lifecycleScope.launch {
                viewModel.doRegister(registerModel).collectLatest {
                    when(it) {
                        is RegisterViewModel.registerState.registerSuccess -> {
                            context?.toast(it.message)
                        }
                        is RegisterViewModel.registerState.registerErrorPasswords -> {
                            context?.toast(it.message)
                        }
                        is RegisterViewModel.registerState.registerError -> {
                            context?.toast(it.message)
                        }
                    }
                }
            }
        }

        binding.registerLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        return view
    }


}