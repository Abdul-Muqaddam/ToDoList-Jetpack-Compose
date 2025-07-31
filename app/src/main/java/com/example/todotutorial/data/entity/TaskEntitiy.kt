package com.example.todotutorial.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TodoList")
data class TaskEntitiy(
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    val name:String,
    val description:String,
    val isCompleted:Boolean=false
)