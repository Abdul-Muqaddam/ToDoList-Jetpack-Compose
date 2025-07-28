package com.example.todotutorial.data.repository

import com.example.todotutorial.data.dao.TaskDao
import com.example.todotutorial.data.entity.TaskEntitiy

class TaskRepository (private val dao: TaskDao){
     fun getAllTasks() = dao.getAllTasks()

    suspend fun addTask(taskEntitiy: TaskEntitiy)=dao.insertTask(taskEntitiy)
    suspend fun updateTask(taskEntitiy: TaskEntitiy)=dao.UpdateTask(taskEntitiy)
    suspend fun deleteTask(taskEntitiy: TaskEntitiy)=dao.DeleteTask(taskEntitiy)
}