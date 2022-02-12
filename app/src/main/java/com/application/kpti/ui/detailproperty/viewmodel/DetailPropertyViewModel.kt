package com.application.kpti.ui.detailproperty.viewmodel

import androidx.lifecycle.ViewModel
import com.application.kpti.ui.detailproperty.repository.DetailPropertyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPropertyViewModel @Inject constructor(repository : DetailPropertyRepository) : ViewModel() {
}