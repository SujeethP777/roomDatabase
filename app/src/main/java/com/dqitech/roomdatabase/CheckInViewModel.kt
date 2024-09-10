package com.dqitech.roomdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckInViewModel @Inject constructor(
    private val repository: CheckInRepository
): ViewModel() {

    private val _checkIns = MutableStateFlow(emptyList<CheckIn>())
    val checkIns: StateFlow<List<CheckIn>> = _checkIns

    init {
        viewModelScope.launch {
            _checkIns.emit(repository.getAllItems())
        }
    }

    fun insertCheckIn(checkIn: CheckIn) {
        viewModelScope.launch {
            repository.insertCheckIn(checkIn)
            _checkIns.emit(repository.getAllItems())
        }
    }
}