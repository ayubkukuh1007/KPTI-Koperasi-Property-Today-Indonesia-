package com.application.kpti.ui.location.viewmodel

import androidx.lifecycle.ViewModel
import com.application.kpti.ui.location.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(repository : LocationRepository) : ViewModel(){
}