package com.application.kpti.ui.profil.pages.info.viewmodel

import androidx.lifecycle.ViewModel
import com.application.kpti.ui.profil.pages.info.repository.RepositoryInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(repository : RepositoryInfo) : ViewModel() {
}