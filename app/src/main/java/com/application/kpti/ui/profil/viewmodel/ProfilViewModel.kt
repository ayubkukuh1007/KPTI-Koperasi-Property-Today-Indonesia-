package com.application.kpti.ui.profil.viewmodel

import androidx.lifecycle.ViewModel
import com.application.kpti.ui.profil.repository.RepositoryProfil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfilViewModel @Inject constructor(repository : RepositoryProfil) : ViewModel() {
}