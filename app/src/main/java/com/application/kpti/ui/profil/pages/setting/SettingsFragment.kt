package com.application.kpti.ui.profil.pages.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import com.application.kpti.R
import com.application.kpti.databinding.FragmentSettingsBinding
import com.application.kpti.ui.profil.pages.setting.model.SettingModel
import com.application.kpti.ui.profil.pages.setting.viewmodel.SettingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    /*val viewModel: SettingViewModel by hiltNavGraphViewModels(R.id.settingsFragment)*/
    val viewModel : SettingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.settingSave.setOnClickListener {
            val agent = binding.settingAgen.text.toString()
            val property = binding.settingProperty.text.toString()
            val email = binding.settingEmail.text.toString()
            val numberPhone = binding.settingPhone.text.toString()

            val settingModel = SettingModel(
                agent = agent,
                property = property,
                email = email,
                phone = numberPhone
            )

            lifecycleScope.launch {
                viewModel.editProfileSetting(settingModel).collectLatest {
                    when(it){
                        is SettingViewModel.profileEditSettingState.settingSuccess -> {
                            context?.toast(it.message)
                        }

                        is  SettingViewModel.profileEditSettingState.settingError -> {
                            context?.toast(it.message)
                        }
                    }
                }
            }
        }
        return view
    }

}