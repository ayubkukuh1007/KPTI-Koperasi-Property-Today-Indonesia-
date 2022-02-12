package com.application.kpti.ui.profil.pages.favorite.viewmodel

import androidx.lifecycle.ViewModel
import com.application.kpti.ui.profil.pages.info.repository.RepositoryInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(repository : RepositoryInfo) : ViewModel() {
}