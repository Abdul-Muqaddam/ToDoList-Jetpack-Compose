package com.example.todotutorial.presentation.dashboard_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todotutorial.data.entity.TaskEntitiy
import com.example.todotutorial.data.repository.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: TaskRepository) : ViewModel() {
    val task = repository.getAllTasks().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000),
        emptyList())

    fun addTask(taskName:String,taskDescription:String){
        viewModelScope.launch {
            repository.addTask(TaskEntitiy(name = taskName, description = taskDescription))
        }
    }

    fun toggleCompletion(taskEntitiy: TaskEntitiy){
        viewModelScope.launch {
            repository.updateTask(taskEntitiy)
        }
    }
    fun deleteTask(taskEntitiy: TaskEntitiy){
        viewModelScope.launch {
            repository.deleteTask(taskEntitiy)
        }
    }

}