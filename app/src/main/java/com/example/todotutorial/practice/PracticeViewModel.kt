package com.example.todotutorial.practice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class PracticeViewModeState(
    var increamentState:Int=0
)


class PracticeViewModel : ViewModel(){
    private val _state= MutableStateFlow(PracticeViewModeState())
    val state: StateFlow<PracticeViewModeState> get() = _state

    fun IncreamentClick(newValue: Int){
        _state.update {
            it.copy(
                increamentState = newValue
            )
        }
    }

}